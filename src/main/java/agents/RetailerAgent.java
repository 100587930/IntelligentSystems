package agents;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
@SuppressWarnings("serial")
public class RetailerAgent extends Agent{
	
	private int PRICE = 10;
	private int OVER_PRICE = 40;
	
	public void setup () {
		addBehaviour(new CyclicBehaviour(this) {
			public void action() {
				ACLMessage msg = receive();
				System.out.println(msg.getContent());
				ACLMessage reply = msg.createReply();
				reply.setContent(Integer.toString(PRICE));
				reply.setPerformative(ACLMessage.INFORM);
				System.out.println("Sending message to " + msg.getSender().getLocalName());
				send(reply);
			}
		});
	}

}
