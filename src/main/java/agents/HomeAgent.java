package agents;

<<<<<<< HEAD
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import main.java.behaviours.HomeCyclicBehaviour;
=======
import java.awt.Color;
import java.util.HashMap;
import java.util.Map.Entry;
import Gui.Model;
import Gui.View;
import behaviours.HomeCyclicBehaviour;
>>>>>>> master
import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import jade.util.leap.ArrayList;
<<<<<<< HEAD
import main.java.models.Appliance;
import main.java.models.Retailer;
import main.java.utils.Constants;
=======
import models.Appliance;
import models.Retailer;
import utils.Constants;
>>>>>>> master

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
<<<<<<< HEAD
=======
	private float previousCheapestPrice = 9999999;
>>>>>>> master
	private int round = 0;
	private int secondRoundProposals = 0;
	private Object[] maxPrice = null;
	boolean isInPriceRange = false;

<<<<<<< HEAD
	public void setup() {
		this.maxPrice = getArguments();
		addBehaviour(new HomeCyclicBehaviour(this));
=======
	private Model model;
	private String[] AppNames = new String[7];
	private String[] RetailNames = new String[7];
	private int AppNumber = 0;
	private int RetailNumber = 0;
	private float time = 0;
	
	public void setup() {

		this.maxPrice = getArguments();
		addBehaviour(new HomeCyclicBehaviour(this));
	    final View view = new View();
	    model = new Model(view);
	}
	
	private void initialize() {
		usageExpected = 0;
		expectedUsagesInformed = 0;
		confirmsReceived = 0;
		proposalsReceived = 0;
		requestsReceived = 0;
		energyMissing = 0;
		energyBought = 0;
		cheapestPrice = 9999999;
		previousCheapestPrice = 9999999;
		round = 0;
		secondRoundProposals = 0;
		isInPriceRange = false;
>>>>>>> master
	}

	public void handleSubscribe(ACLMessage msg) {
		switch (msg.getContent()) {
		case (Constants.APPLIANCE_AGENT):
			applianceAgents.put(msg.getSender(), null);
			System.out.println("Appliance subscribed: " + msg.getSender().getLocalName());
<<<<<<< HEAD
=======
			AppNames[AppNumber] = msg.getSender().getLocalName();
			model.setupLines(msg.getSender().getLocalName(), AppNumber);
			AppNumber++;
>>>>>>> master
			break;

		case (Constants.RETAILER_AGENT):
			retailerAgents.put(msg.getSender(), null);
			System.out.println("Retailer subscribed: " + msg.getSender().getLocalName());
<<<<<<< HEAD
			break;
		}
	}

=======
			RetailNames[RetailNumber] = msg.getSender().getLocalName();
			model.setupLines(msg.getSender().getLocalName(), RetailNumber + 7);
			RetailNumber++;
			break;
		}
		model.AssignAppAgentsNames(AppNames);
		model.AssignRetailAgentsNames(RetailNames);
	}


>>>>>>> master
	public float getMaxPrice() {
		return (float) this.maxPrice[0];
	}

	public void handleInform(ACLMessage msg) {

		this.applianceAgents.put(msg.getSender(), new Appliance(Float.parseFloat(msg.getContent())));

		System.out.println("Agent " + msg.getSender().getLocalName() + " expected usage is - "
				+ this.applianceAgents.get(msg.getSender()).getEnergyExpected());

		this.usageExpected = this.usageExpected + this.applianceAgents.get(msg.getSender()).getEnergyExpected();

		this.expectedUsagesInformed++;

		if (this.expectedUsagesInformed == Constants.APPLIANCE_AGENTS_COUNT) {
			this.startNegotiation();
			this.expectedUsagesInformed = 0;
		}
<<<<<<< HEAD
=======
		String CurrentAgent = msg.getSender().getLocalName();
		for(int i = 0; i < AppNumber; i++) {
			if(CurrentAgent.trim().equals(AppNames[i].trim())) {
				model.AssignNewValues(this.applianceAgents.get(msg.getSender()).getEnergyExpected(), i);
				model.addData(time, this.applianceAgents.get(msg.getSender()).getEnergyExpected(), i);
				if(i == 1) {
				time = time + 15;
				}
			}
		}
		
>>>>>>> master
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
<<<<<<< HEAD
		retailer.setPrice(Float.parseFloat(msg.getContent()));
=======
		retailer.setPrice(Float.parseFloat(msg.getContent()));		
>>>>>>> master
		retailer.incrementRound();
		this.retailerAgents.get(msg.getSender()).setPrice(Float.parseFloat(msg.getContent()));
		this.proposalsReceived++;
		if (this.round == 1 && this.proposalsReceived == Constants.RETAILER_AGENTS_COUNT) {
			setCheapestPrice();
			this.isInPriceRange = this.cheapestPrice <= this.getMaxPrice();
			this.renegotiate();
			this.proposalsReceived = 0;
		} else if (this.round == 2 && this.secondRoundProposals == this.proposalsReceived) {
<<<<<<< HEAD
=======
			model.AssignAccept("Rejected", 10);
>>>>>>> master
			setCheapestPrice();
			this.isInPriceRange = this.cheapestPrice <= this.getMaxPrice();
			notifyRetailers();
			notifyAppliances();
			this.proposalsReceived = 0;
<<<<<<< HEAD
=======
			initialize();
>>>>>>> master
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
<<<<<<< HEAD
		float zero = 0;
		for (Entry<AID, Retailer> entry : this.retailerAgents.entrySet()) {
			Retailer retailer = entry.getValue();
			ACLMessage msg = new ACLMessage(ACLMessage.ACCEPT_PROPOSAL);
			if (retailer.getRound() == 2) {
				msg.setPerformative(ACLMessage.ACCEPT_PROPOSAL);
=======
		for (Entry<AID, Retailer> entry : this.retailerAgents.entrySet()) {
			Retailer retailer = entry.getValue();
			ACLMessage msg = new ACLMessage(ACLMessage.ACCEPT_PROPOSAL);
			if (retailer.getRound() == 2 && retailer.getPrice() != 0f) {
				msg.setPerformative(ACLMessage.ACCEPT_PROPOSAL);
				int iend = entry.getKey().getName().indexOf("@");
				String CurrentAgent = entry.getKey().getName().substring(0, iend);
				for(int i = 0; i < RetailNumber; i++) {
					if(CurrentAgent.trim().equals(RetailNames[i].trim())) {
						model.AssignAccept("accepted", i);
					}
				}
>>>>>>> master
				System.out.println("Accepting proposal: $" + retailer.getPrice() + " for " + retailer.getEnergyDemand()
						+ " of energy");
				this.energyBought += retailer.getEnergyDemand(); 
			} else {
				msg.setPerformative(ACLMessage.REJECT_PROPOSAL);
			}
			msg.addReceiver(entry.getKey());
			send(msg);
<<<<<<< HEAD
		}
	}
=======
			}
		}
>>>>>>> master

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
<<<<<<< HEAD
=======
				int iend = entry.getKey().getName().indexOf("@");
				String CurrentAgent = entry.getKey().getName().substring(0, iend);
				for(int i = 0; i < RetailNumber; i++) {
					if(CurrentAgent.trim().equals(RetailNames[i].trim())) {
						model.AssignProposed(entry.getValue().getPrice(), i);
						model.addData(time, entry.getValue().getPrice(), i + 7);
						model.AssignPowerOffer(this.usageExpected, i);
					}
				}	
				
>>>>>>> master
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
<<<<<<< HEAD
		for (Entry<AID, Retailer> entry : this.retailerAgents.entrySet()) {
			float agentPrice = entry.getValue().getPrice();
			if (agentPrice != this.cheapestPrice && newCheapestPrice == 0) {
				newCheapestPrice = agentPrice > this.cheapestPrice ? agentPrice : newCheapestPrice;
			} else if (agentPrice != this.cheapestPrice && newCheapestPrice > 0) {
				newCheapestPrice = agentPrice < newCheapestPrice ? agentPrice : newCheapestPrice;
=======
		this.previousCheapestPrice = this.cheapestPrice;
		for (Entry<AID, Retailer> entry : this.retailerAgents.entrySet()) {
			float agentPrice = entry.getValue().getPrice();
			if (agentPrice != this.cheapestPrice && newCheapestPrice == 0) {
				newCheapestPrice = agentPrice > this.cheapestPrice ? agentPrice : 0;
			} 
			else if (agentPrice != this.cheapestPrice && newCheapestPrice > 0) {
				newCheapestPrice = agentPrice > this.cheapestPrice && agentPrice < newCheapestPrice ? agentPrice : newCheapestPrice;
>>>>>>> master
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
<<<<<<< HEAD
		float totalCap = getTotalCap();
		float difference = totalCap < this.usageExpected ? this.usageExpected - totalCap : 0;
=======
>>>>>>> master
		float splitDemand = this.usageExpected / this.retailerAgents.size();
		ACLMessage proposeMessage = null;
		for (Entry<AID, Retailer> entry : this.retailerAgents.entrySet()) {
			float agentCap = entry.getValue().getCap();
			float energyWanted = splitDemand > agentCap ? agentCap : splitDemand;
<<<<<<< HEAD
			totalCap -= energyWanted;
=======
>>>>>>> master
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
<<<<<<< HEAD
		if(this.requestsReceived == Constants.APPLIANCE_AGENTS_COUNT) {
			if(this.energyMissing > 0) {
				System.out.println("Penalty! " + this.energyMissing + " kw of energy missing");		
			} else if (this.energyMissing == 0) {
				System.out.println("All appliances received at least the right amount of energy they needed");	
			}
			System.out.println("System exiting...");
			System.exit(0);
=======
		if(this.requestsReceived == AppNumber) {
			if(this.energyMissing > 0) {
				System.out.println("Penalty! " + this.energyMissing + " kw of energy missing");
				model.PowerSupplyColour(Color.red, this.energyMissing);
			} else if (this.energyMissing == 0) {
				System.out.println("All appliances received at least the right amount of energy they needed");	
				model.PowerSupplyColour(Color.green, this.energyMissing);
			}
			System.out.println("System exiting...");
			//System.exit(0);
>>>>>>> master
		}
	}

}
