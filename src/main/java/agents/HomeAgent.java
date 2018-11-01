package agents;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import Gui.Model;
import Gui.View;
import behaviours.HomeCyclicBehaviour;
import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import jade.util.leap.ArrayList;
import models.Appliance;
import models.Retailer;
import utils.Constants;
import controllers.MainController;

@SuppressWarnings("serial")
public class HomeAgent extends Agent {

	private HashMap<AID, Appliance> applianceAgents = new HashMap<AID, Appliance>();
	private HashMap<AID, Retailer> retailerAgents = new HashMap<AID, Retailer>();

	private float usageExpected;
	private float expectedUsagesInformed = 0;
	private int confirmsReceived = 0;
	private int proposalsReceived = 0;
	private int requestsReceived = 0;
	private float energyMissing = 0;
	private float energyBought = 0;
	private float cheapestPrice = 9999999;
	private int round = 0;
	private int secondRoundProposals = 0;
	private Object[] maxPrice = null;
	boolean isInPriceRange = false;

	private Model model;
	private String[] AppNames = new String[7];
	private int AppNumber = 0;
	
	public void setup() {	    

		this.maxPrice = getArguments();
		addBehaviour(new HomeCyclicBehaviour(this));
	    final View view = new View();
	    model = new Model(view);
	}

	public void handleSubscribe(ACLMessage msg) {
		switch (msg.getContent()) {
		case (Constants.APPLIANCE_AGENT):
			applianceAgents.put(msg.getSender(), null);
			System.out.println("Appliance subscribed: " + msg.getSender().getLocalName());
			AppNames[AppNumber] = msg.getSender().getLocalName();
			AppNumber++;
			break;

		case (Constants.RETAILER_AGENT):
			retailerAgents.put(msg.getSender(), null);
			System.out.println("Retailer subscribed: " + msg.getSender().getLocalName());
			break;
		}
		
		model.AssignAppAgentsNames(AppNames);
	}


	public float getMaxPrice() {
		return (float) this.maxPrice[0];
	}

	public void handleInform(ACLMessage msg) {

		this.applianceAgents.put(msg.getSender(), new Appliance(Float.parseFloat(msg.getContent())));

		System.out.println("Agent " + msg.getSender().getLocalName() + " expected usage is - "
				+ this.applianceAgents.get(msg.getSender()).getEnergyExpected());
		int[] array = {1,2,3,4,5,6,7};
		model.AssignNewValues(array, 7);

		this.usageExpected = this.usageExpected + this.applianceAgents.get(msg.getSender()).getEnergyExpected();

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
		return Float.toString(this.usageExpected);
	}

	public void handlePropose(ACLMessage msg) {
		Retailer retailer = this.retailerAgents.get(msg.getSender());
		retailer.setPrice(Float.parseFloat(msg.getContent()));
		retailer.incrementRound();
		this.retailerAgents.get(msg.getSender()).setPrice(Float.parseFloat(msg.getContent()));
		this.proposalsReceived++;
		if (this.round == 1 && this.proposalsReceived == Constants.RETAILER_AGENTS_COUNT) {
			setCheapestPrice();
			this.isInPriceRange = this.cheapestPrice <= this.getMaxPrice();
			this.renegotiate();
			this.proposalsReceived = 0;
		} else if (this.round == 2 && this.secondRoundProposals == this.proposalsReceived) {
			setCheapestPrice();
			this.isInPriceRange = this.cheapestPrice <= this.getMaxPrice();
			notifyRetailers();
			notifyAppliances();
			this.proposalsReceived = 0;
		}
	}

	private void notifyAppliances() {
		for (Entry<AID, Appliance> entry : this.applianceAgents.entrySet()) {
			Appliance appliance = entry.getValue();
			float energyGiven = 0;
			if(this.energyBought > 0) {
				energyGiven = this.energyBought - appliance.getEnergyExpected() < 0 ? this.energyBought : appliance.getEnergyExpected();
			}
			System.out.println("GIVING: " + energyGiven + " of energy");
			this.energyBought -= appliance.getEnergyExpected();
			ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
			msg.setContent(Float.toString(energyGiven));
			msg.addReceiver(entry.getKey());
			send(msg);
		}
		System.out.println("-- NOTIFYING APPLIANCES --");
	}

	private void notifyRetailers() {
		for (Entry<AID, Retailer> entry : this.retailerAgents.entrySet()) {
			Retailer retailer = entry.getValue();
			ACLMessage msg = new ACLMessage(ACLMessage.ACCEPT_PROPOSAL);
			if (retailer.getRound() == 2) {
				msg.setPerformative(ACLMessage.ACCEPT_PROPOSAL);
				System.out.println("Accepting proposal: $" + retailer.getPrice() + " for " + retailer.getEnergyDemand()
						+ " of energy");
				this.energyBought += retailer.getEnergyDemand(); 
			} else {
				msg.setPerformative(ACLMessage.REJECT_PROPOSAL);
			}
			msg.addReceiver(entry.getKey());
			send(msg);
		}
	}

	private void setCheapestPrice() {
		for (Entry<AID, Retailer> entry : this.retailerAgents.entrySet()) {
			float agentPrice = entry.getValue().getPrice();
			this.cheapestPrice = agentPrice < this.cheapestPrice ? agentPrice : this.cheapestPrice;
		}
	}

	private void renegotiate() {
		System.out.println("-- RENEGOTIATING --");
		float totalCap = getTotalCap();
		HashMap<AID, Float> retailerDeals = new HashMap<AID, Float>();
		ArrayList messages = new ArrayList();
		float energyDistributed = this.usageExpected;
		float difference = totalCap < this.usageExpected ? this.usageExpected - totalCap : 0;
		while ((energyDistributed - difference) != 0) {
			for (Entry<AID, Retailer> entry : this.retailerAgents.entrySet()) {
				if (entry.getValue().getPrice() == this.cheapestPrice) {
					ACLMessage msg = new ACLMessage(ACLMessage.PROPOSE);
					float agentCap = entry.getValue().getCap();
					float splitDemand = energyDistributed - agentCap < 0 ? energyDistributed : agentCap;
					float energyWanted = splitDemand > agentCap ? agentCap : splitDemand;
					retailerDeals.put(entry.getKey(), energyWanted);
					energyDistributed -= energyWanted;
					msg.setContent(Float.toString(energyWanted));
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
		this.secondRoundProposals = messages.size();
		this.round++;
	}

	private void setHigherCheapestPrice() {
		float newCheapestPrice = 0;
		for (Entry<AID, Retailer> entry : this.retailerAgents.entrySet()) {
			float agentPrice = entry.getValue().getPrice();
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
		float totalCap = getTotalCap();
		float difference = totalCap < this.usageExpected ? this.usageExpected - totalCap : 0;
		float splitDemand = this.usageExpected / this.retailerAgents.size();
		ACLMessage proposeMessage = null;
		for (Entry<AID, Retailer> entry : this.retailerAgents.entrySet()) {
			float agentCap = entry.getValue().getCap();
			float energyWanted = splitDemand > agentCap ? agentCap : splitDemand;
			totalCap -= energyWanted;
			proposeMessage = new ACLMessage(ACLMessage.PROPOSE);
			proposeMessage.setContent(Float.toString(energyWanted));
			proposeMessage.addReceiver(entry.getKey());
			send(proposeMessage);
		}
		this.round++;
	}

	private float getTotalCap() {
		float totalCap = 0;
		for (Entry<AID, Retailer> entry : this.retailerAgents.entrySet()) {
			totalCap += entry.getValue().getCap();
		}
		return totalCap;
	}

	public void handleRequest(ACLMessage msg) {
		Appliance appliance = this.applianceAgents.get(msg.getSender());
		appliance.setEnergyDemand(Float.parseFloat(msg.getContent()));
		this.applianceAgents.put(msg.getSender(), appliance);
		this.energyMissing += Float.parseFloat(msg.getContent());
		this.requestsReceived++;
		if(this.requestsReceived == Constants.APPLIANCE_AGENTS_COUNT) {
			if(this.energyMissing > 0) {
				System.out.println("Penalty! " + this.energyMissing + " kw of energy missing");		
			} else if (this.energyMissing == 0) {
				System.out.println("All appliances received at least the right amount of energy they needed");	
			}
			System.out.println("System exiting...");
			//System.exit(0);
		}
	}

}
