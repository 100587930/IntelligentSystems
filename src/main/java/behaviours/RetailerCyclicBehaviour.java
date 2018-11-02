package behaviours;

import java.io.IOException;

import agents.HomeAgent;
import agents.RetailerAgent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

@SuppressWarnings("serial")
public class RetailerCyclicBehaviour extends CyclicBehaviour {

	private RetailerAgent retailerAgent;

	public RetailerCyclicBehaviour(RetailerAgent retailerAgent) {
		this.retailerAgent = retailerAgent;
	}

	@Override
	public void action() {
		ACLMessage msg = this.retailerAgent.receive();
		if (msg != null) {
			switch (msg.getPerformative()) {
			case ACLMessage.INFORM:
				try {
					this.retailerAgent.handleInform(msg);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case ACLMessage.ACCEPT_PROPOSAL:
				this.retailerAgent.handleAccept(msg);
				break;
			case ACLMessage.REJECT_PROPOSAL:
				this.retailerAgent.handleReject(msg);
				break;
			case ACLMessage.PROPOSE:
				this.retailerAgent.handlePropose(msg);
			}
		}
	}

}
