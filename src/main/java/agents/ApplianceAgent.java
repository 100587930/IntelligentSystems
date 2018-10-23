package agents;

import behaviours.ApplianceTickerBehaviour;
import jade.core.*;
import jade.lang.acl.ACLMessage;

import jade.core.Agent;
//import java.util.Iterator;
//import jade.core.behaviours.Behaviour;



import utils.Constants;


@SuppressWarnings("serial")
public class ApplianceAgent extends Agent {

	private int energyExpected; 	//TODO: Get information from data set
	private AID homeAgent = Constants.HOME_AGENT_AID; 
	private int mSecondsToInform = 10000; //change for different frequencies
	
	protected void setup() {
		this.subscribe();
		addBehaviour(new ApplianceTickerBehaviour(this, this.mSecondsToInform));
	}
	
	public String getExpectedUsage() {
		return Integer.toString(this.energyExpected);
	}

	public void setExpectedUsage(int energyUsage) {
		this.energyExpected = energyUsage;
	}
	
	private void subscribe() {
		ACLMessage msg = new ACLMessage(ACLMessage.SUBSCRIBE);
		msg.setContent(Constants.APPLIANCE_AGENT);
		msg.addReceiver(this.homeAgent);
		send(msg);
	}


}
