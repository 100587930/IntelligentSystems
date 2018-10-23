package agents;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import behaviours.HomeCyclicBehaviour;
import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import jade.util.leap.ArrayList;
import models.Retailer;
import utils.Constants;

@SuppressWarnings("serial")
public class HomeAgent extends Agent {

	private HashMap<AID, Integer> applianceAgents = new HashMap<AID, Integer>();
	private HashMap<AID, Retailer> retailerAgents = new HashMap<AID, Retailer>();

	private int usageExpected;
	private int expectedUsagesInformed = 0;
	private int confirmsReceived = 0;
	private int proposalsReceived = 0;
	private int cheapestPrice = 9999999;
	private int round = 0;
	private Object[] maxPrice = null;
	boolean isInPriceRange = false;

	public void setup() {
		this.maxPrice = getArguments();
		addBehaviour(new HomeCyclicBehaviour(this));
	}

	public void handleSubscribe(ACLMessage msg) {
		switch (msg.getContent()) {
		case (Constants.APPLIANCE_AGENT):
			applianceAgents.put(msg.getSender(), null);
			System.out.println("Appliance subscribed: " + msg.getSender().getLocalName());
			break;

		case (Constants.RETAILER_AGENT):
			retailerAgents.put(msg.getSender(), null);
			System.out.println("Retailer subscribed: " + msg.getSender().getLocalName());
			break;
		}
	}

	public int getMaxPrice() {
		return (int) this.maxPrice[0];
	}

	public void handleInform(ACLMessage msg) {

		this.applianceAgents.put(msg.getSender(), Integer.parseInt(msg.getContent()));

		System.out.println("Agent " + msg.getSender().getLocalName() + " expected usage is - "
				+ this.applianceAgents.get(msg.getSender()));

		this.usageExpected = this.usageExpected + this.applianceAgents.get(msg.getSender());

		this.expectedUsagesInformed++;

		if (this.expectedUsagesInformed == Constants.APPLIANCE_AGENTS_COUNT) {
			this.startNegotiation();
			this.expectedUsagesInformed = 0;
		}
	}

	private void startNegotiation() {
		System.out.println("Starting negotiation");
		System.out.println("Energy being requested: " + this.getUsageExpected());
		for (Entry<AID, Retailer> entry : this.retailerAgents.entrySet()) {
			// Sends message to start the negotiation with the retailer agents
			ACLMessage negotiationMsg = new ACLMessage(ACLMessage.INFORM);
			negotiationMsg.setContent(this.getUsageExpected());
			negotiationMsg.addReceiver(entry.getKey());
			send(negotiationMsg);
		}
	}

	private String getUsageExpected() {
		return Integer.toString(this.usageExpected);
	}

	public void handlePropose(ACLMessage msg) {
		this.retailerAgents.get(msg.getSender()).setPrice(Integer.parseInt(msg.getContent()));
		this.proposalsReceived++;
		if (this.proposalsReceived == Constants.RETAILER_AGENTS_COUNT) {
			setCheapestPrice();
			this.isInPriceRange = this.cheapestPrice <= this.getMaxPrice();
			if (this.round == 1) {
				this.renegotiate();
			} else if (this.round == 2) {
				notifyRetailers();
				notifyAppliances();
			}
			this.proposalsReceived = 0;
		}
	}

	private void notifyAppliances() {
		for (Entry<AID, Integer> entry : this.applianceAgents.entrySet()) {
			
		}
		
	}

	private void notifyRetailers() {
		for (Entry<AID, Retailer> entry : this.retailerAgents.entrySet()) {
			Retailer retailer = entry.getValue();
			System.out.println("Accepting proposal: $" + retailer.getPrice() + " for " + retailer.getEnergyDemand() + " of energy");
			ACLMessage msg = new ACLMessage(ACLMessage.ACCEPT_PROPOSAL);
			msg.addReceiver(entry.getKey());
			send(msg);
		}
		
	}

	private void setCheapestPrice() {
		for (Entry<AID, Retailer> entry : this.retailerAgents.entrySet()) {
			int agentPrice = entry.getValue().getPrice();
			this.cheapestPrice = agentPrice < this.cheapestPrice ? agentPrice : this.cheapestPrice;
		}
	}

	private void renegotiate() {
		int totalCap = getTotalCap();
		HashMap<AID, Integer> retailerDeals = new HashMap<AID, Integer>();
		ArrayList messages = new ArrayList();
		int energyDistributed = this.usageExpected;
		int difference = totalCap < this.usageExpected ? this.usageExpected - totalCap : 0;
		while ((energyDistributed - difference) != 0) {
			for (Entry<AID, Retailer> entry : this.retailerAgents.entrySet()) {
				if (entry.getValue().getPrice() == this.cheapestPrice) {
					ACLMessage msg = new ACLMessage(ACLMessage.PROPOSE);
					int agentCap = entry.getValue().getCap();
					int splitDemand = energyDistributed - agentCap < 0 ? energyDistributed : agentCap;
					int energyWanted = splitDemand > agentCap ? agentCap : splitDemand;
					retailerDeals.put(entry.getKey(), energyWanted);
					energyDistributed -= energyWanted;
					msg.setContent(Integer.toString(energyWanted));
					entry.getValue().setEnergyDemand(energyWanted);
					msg.addReceiver(entry.getKey());
					messages.add(msg);
					setHigherCheapestPrice();
				}
			}
		}
		for (int i = 0; i < messages.size(); i++) {
			send((ACLMessage) messages.get(i));
		}
		this.round++;
	}

	private void setHigherCheapestPrice() {
		int newCheapestPrice = 0;
		for (Entry<AID, Retailer> entry : this.retailerAgents.entrySet()) {
			int agentPrice = entry.getValue().getPrice();
			if (agentPrice != this.cheapestPrice && newCheapestPrice == 0) {
				newCheapestPrice = agentPrice > this.cheapestPrice ? agentPrice : newCheapestPrice;
			} else if (agentPrice != this.cheapestPrice && newCheapestPrice > 0) {
				newCheapestPrice = agentPrice < newCheapestPrice ? agentPrice : newCheapestPrice;
			}
		}
		this.cheapestPrice = newCheapestPrice;
	}

	public void handleConfirm(ACLMessage msg) throws UnreadableException {
		// Home agent receives the cap from every retailer agent
		this.confirmsReceived++;
		this.retailerAgents.put(msg.getSender(), (Retailer) msg.getContentObject());
		if (confirmsReceived == this.retailerAgents.size()) {
			this.proposeOffer();
		}
	}

	private void proposeOffer() {
		int totalCap = getTotalCap();
		int difference = totalCap < this.usageExpected ? this.usageExpected - totalCap : 0;
		int splitDemand = this.usageExpected / this.retailerAgents.size();
		ACLMessage proposeMessage = null;
		for (Entry<AID, Retailer> entry : this.retailerAgents.entrySet()) {
			int agentCap = entry.getValue().getCap();
			int energyWanted = splitDemand > agentCap ? agentCap : splitDemand;
			totalCap -= energyWanted;
			proposeMessage = new ACLMessage(ACLMessage.PROPOSE);
			proposeMessage.setContent(Integer.toString(energyWanted));
			proposeMessage.addReceiver(entry.getKey());
			send(proposeMessage);
		}
		this.round++;
	}

	private int getTotalCap() {
		int totalCap = 0;
		for (Entry<AID, Retailer> entry : this.retailerAgents.entrySet()) {
			totalCap += entry.getValue().getCap();
		}
		return totalCap;
	}

}
