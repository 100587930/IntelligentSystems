package behaviours;
import agents.HomeAgent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;

@SuppressWarnings("serial")
public class HomeCyclicBehaviour extends CyclicBehaviour {
	
	private HomeAgent homeAgent;
	
	public HomeCyclicBehaviour(HomeAgent homeAgent) {
		this.homeAgent = homeAgent;
	}

	@Override
	public void action() {
		ACLMessage msg = this.homeAgent.receive();
		if(msg != null) {
			switch(msg.getPerformative()) {
			case ACLMessage.SUBSCRIBE:
				this.homeAgent.handleSubscribe(msg);
				break;
			case ACLMessage.INFORM:
				this.homeAgent.handleInform(msg);
				break;
			case ACLMessage.PROPOSE:
				this.homeAgent.handlePropose(msg);
				break;
			case ACLMessage.REQUEST:
				this.homeAgent.handleRequest(msg);
				break;
			case ACLMessage.CONFIRM:
				try {
					this.homeAgent.handleConfirm(msg);
				} catch (UnreadableException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
	

}
