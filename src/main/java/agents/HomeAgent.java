package agents;

import java.util.HashMap;
import behaviours.HomeCyclicBehaviour;
import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;

@SuppressWarnings("serial")
public class HomeAgent extends Agent {
	
	private HashMap<AID, Integer> applianceAgents = new HashMap<AID, Integer>();
	
	private int totalUsed;
	//private int totalExpected;
	private int i = 0;
	
	
	
	public void setup () {
		addBehaviour(new HomeCyclicBehaviour(this));
	}
	
	public void handleSubscribe(ACLMessage msg) {
		applianceAgents.put(msg.getSender(), null);
	}
	
	public void handleInform(ACLMessage msg) {
		this.applianceAgents.put(msg.getSender(), Integer.parseInt(msg.getContent()));
		//System.out.println("haha");
		System.out.println(Integer.parseInt(msg.getContent()));
		
		totalUsed = totalUsed + Integer.parseInt(msg.getContent());
		
		System.out.println("Total electricity this hour: " + totalUsed);
		
			i = i + 1;
		System.out.println("Tick: " + i);
			if (i == 120) {
				i = 0;
				totalUsed = 0;
			}
		}
		
	}
	

