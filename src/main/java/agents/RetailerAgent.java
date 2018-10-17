package agents;

import behaviours.HomeCyclicBehaviour;
import behaviours.RetailerCyclicBehaviour;
import jade.core.AID;
import jade.core.Agent;

import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import utils.Constants;
@SuppressWarnings("serial")
public class RetailerAgent extends Agent{
	
	private int pricePerKW = 10;
	private int OVER_PRICE = 40;
	private AID homeAgent = Constants.HOME_AGENT_AID;
	
	public void setup () {
		this.subscribe();
		addBehaviour(new RetailerCyclicBehaviour(this));

	}
	
	private void subscribe() {
		ACLMessage msg = new ACLMessage(ACLMessage.SUBSCRIBE);
		msg.setContent(Constants.RETAILER_AGENT);
		msg.addReceiver(this.homeAgent);
		send(msg);
	}
	
	private int getCalculatedPrice() {
		return Integer.toString((int) (Math.random() * energyWanted));
	}

	public void handleInform(ACLMessage msg) {
		//Random prices
		int energyWanted = Integer.parseInt(msg.getContent());
		String energyPrice = getCalculatedPrice();
		ACLMessage proposeMsg = new ACLMessage(ACLMessage.PROPOSE);
		proposeMsg.setContent(energyPrice);
		proposeMsg.addReceiver(this.homeAgent);
		System.out.println(this.getLocalName() + " proposes $" + energyPrice + " dollars to sell the energy" );
		send(proposeMsg);
	}

	public void handleAccept(ACLMessage msg) {
		System.out.println(this.getLocalName() + " proposal has been accepted");
	}

	public void handleReject(ACLMessage msg) {
		System.out.println(this.getLocalName() + " proposal has been refused");
	}

	public void handlePropose(ACLMessage msg) {
		while(msg.getContent() )
		
	}

}
