package agents;

import java.util.HashMap;
import behaviours.HomeCyclicBehaviour;
import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;

@SuppressWarnings("serial")
public class HomeAgent extends Agent {
	
	private HashMap<AID, Integer> applianceAgents = new HashMap<AID, Integer>();
	
	
	public void setup () {
		addBehaviour(new HomeCyclicBehaviour(this));
	}
	
	public void handleSubscribe(ACLMessage msg) {
		applianceAgents.put(msg.getSender(), null);
	}
	
	public void handleInform(ACLMessage msg) {
		this.applianceAgents.put(msg.getSender(), Integer.parseInt(msg.getContent()));
		System.out.println("haha");
	}
	
}
