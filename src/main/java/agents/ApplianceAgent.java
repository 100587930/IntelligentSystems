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


	private int timeSlots; //hours
	//TODO: Get information from data set
	private int energyUsage; //Fake data
	private AID homeAgent = Constants.HOME_AGENT_AID; 
	private int mSecondsToInform = 1000; //change for different frequencies
	
	protected void setup() {
		this.subscribe();
		addBehaviour(new ApplianceTickerBehaviour(this, this.mSecondsToInform));
	}

	private void subscribe() {
		ACLMessage msg = new ACLMessage(ACLMessage.SUBSCRIBE);
		msg.addReceiver(this.homeAgent);
		send(msg);
	}
	
	public String getEnergyUsage() {
		//System.out.println(this.energyUsage);  
		return Integer.toString(this.energyUsage);
	}

	public void setEnergyUsage(int energyUsage) {
		this.energyUsage = energyUsage;
	}

}
