package behaviours;

import agents.ApplianceAgent;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;
import utils.Constants;

@SuppressWarnings("serial")
public class ApplianceTickerBehaviour extends TickerBehaviour {

	private ApplianceAgent applianceAgent;
	
	public ApplianceTickerBehaviour(ApplianceAgent applianceAgent, long period) {
		super(applianceAgent, period);
		this.applianceAgent = applianceAgent;
	}

	@Override
	protected void onTick() {

		this.applianceAgent.setExpectedUsage((int) (Math.random() * 50));

		ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
		msg.addReceiver(Constants.HOME_AGENT_AID);
		msg.setContent(this.applianceAgent.getExpectedUsage());
		this.applianceAgent.send(msg);
	}

}
