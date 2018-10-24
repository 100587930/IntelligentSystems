package agents;

import behaviours.ApplianceCyclicBehaviour;
import behaviours.ApplianceTickerBehaviour;
import behaviours.RetailerCyclicBehaviour;
import jade.core.*;
import jade.lang.acl.ACLMessage;

import jade.core.Agent;
//import java.util.Iterator;
//import jade.core.behaviours.Behaviour;

import utils.Constants;

@SuppressWarnings("serial")
public class ApplianceAgent extends Agent {

	private float energyExpected; // TODO: Get information from data set
	private float energyUsage;
	private AID homeAgent = Constants.HOME_AGENT_AID;
	private long mSecondsToInform = 10000; // change for different frequencies

	protected void setup() {
		this.subscribe();
		addBehaviour(new ApplianceTickerBehaviour(this, this.mSecondsToInform));
		addBehaviour(new ApplianceCyclicBehaviour(this));
	}

	public String getExpectedUsage() {
		return Float.toString(this.energyExpected);
	}

	public void setExpectedUsage(float energyUsage) {
		this.energyExpected = energyUsage;
	}

	private void subscribe() {
		ACLMessage msg = new ACLMessage(ACLMessage.SUBSCRIBE);
		msg.setContent(Constants.APPLIANCE_AGENT);
		msg.addReceiver(this.homeAgent);
		send(msg);
	}

	public void handleInform() {
		ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
		msg.setContent(Float.toString(this.getEnergyUsage()));
		msg.addReceiver(this.homeAgent);
		send(msg);
	}

	public float getEnergyUsage() {
		// TODO: change it later with the real usage
		this.energyUsage = this.energyExpected + 1;
		return this.energyUsage;
	}

}
