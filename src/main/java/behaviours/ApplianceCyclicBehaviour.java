package behaviours;

import java.io.IOException;

import agents.ApplianceAgent;
import agents.RetailerAgent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class ApplianceCyclicBehaviour extends CyclicBehaviour {

	private ApplianceAgent applianceAgent;

	public ApplianceCyclicBehaviour(ApplianceAgent applianceAgent) {
		this.applianceAgent = applianceAgent;
	}

	@Override
	public void action() {
		ACLMessage msg = this.applianceAgent.receive();
		if (msg != null) {
			switch (msg.getPerformative()) {
			case ACLMessage.INFORM:
				this.applianceAgent.handleInform();
				break;
			}
		}
	}
}
