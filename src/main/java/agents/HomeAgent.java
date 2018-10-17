package agents;

import java.util.HashMap;
import java.util.Iterator;

import behaviours.HomeCyclicBehaviour;
import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;
import utils.Constants;

@SuppressWarnings("serial")
public class HomeAgent extends Agent {

	private HashMap<AID, Integer> applianceAgents = new HashMap<AID, Integer>();
	private HashMap<AID, Integer> retailerAgents = new HashMap<AID, Integer>();

	private int usageExpected;
	private int usagesInformed = 0;
	private int proposalsReceived = 0;
	private int cheapestPrice = 9999999;
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

		System.out.println("Agent " + msg.getSender().getLocalName() + " usage is - " + this.applianceAgents.get(msg.getSender()));
		
		this.usageExpected = this.usageExpected + this.applianceAgents.get(msg.getSender());
		
		this.usagesInformed++;
		
		if(this.usagesInformed == Constants.APPLIANCE_AGENTS_COUNT) {
			this.startNegotiation();
			this.usagesInformed = 0;
		}
	}

	private void startNegotiation() {
		System.out.println("Starting negotiation");
		System.out.println("Energy demand: " + this.getUsageExpected());
		for (HashMap.Entry<AID, Integer> entry : this.retailerAgents.entrySet()) {
			//Sends message to start the negotiation with the retailer agents
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
		this.retailerAgents.put(msg.getSender(), Integer.parseInt(msg.getContent()));
		int agentProposal = Integer.parseInt(msg.getContent());
		this.cheapestPrice = agentProposal < this.cheapestPrice ? agentProposal : this.cheapestPrice;
		this.isInPriceRange = this.cheapestPrice <= this.getMaxPrice();
		this.proposalsReceived++;
		if(this.proposalsReceived == Constants.RETAILER_AGENTS_COUNT) {
			this.chooseBestDeal();
			this.proposalsReceived = 0;
		}
	}

	private void chooseBestDeal() {
		System.out.println("Choosing best deal");
		ACLMessage msg = null;
		
		for (HashMap.Entry<AID, Integer> entry : this.retailerAgents.entrySet()) {
			if(this.isInPriceRange) {
				if(this.retailerAgents.get(entry.getKey()) == this.cheapestPrice) {
					msg = new ACLMessage(ACLMessage.ACCEPT_PROPOSAL);
				} else {
					msg = new ACLMessage(ACLMessage.REJECT_PROPOSAL);
				}
			} else {
				msg = new ACLMessage(ACLMessage.PROPOSE);
				msg.setContent(getUsageExpected());
			}
			msg.addReceiver(entry.getKey());
			send(msg);
			this.usageExpected = 0;
		}
	}

}
