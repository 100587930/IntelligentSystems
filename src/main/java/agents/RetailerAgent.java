package agents;

import java.io.IOException;
import behaviours.RetailerCyclicBehaviour;
import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;
import models.Retailer;
import tariffs.Tariff;
import utils.Constants;
import utils.TariffSwitch;
@SuppressWarnings("serial")
public class RetailerAgent extends Agent{
	
	
	private AID homeAgent = Constants.HOME_AGENT_AID;
	private Tariff tariff;
	
	public void setup () {
		this.subscribe();
		addBehaviour(new RetailerCyclicBehaviour(this));
		Object[] retailerArgments = getArguments();
		this.tariff = TariffSwitch.getTariff(retailerArgments);
	}
	
	private void subscribe() {
		ACLMessage msg = new ACLMessage(ACLMessage.SUBSCRIBE);
		msg.setContent(Constants.RETAILER_AGENT);
		msg.addReceiver(this.homeAgent);
		send(msg);
	}
	
	private String getCalculatedPrice(int energyWanted) {
		return Integer.toString(this.tariff.calculateOffer(energyWanted));
	}
	
	public void handleInform(ACLMessage msg) throws IOException {
		ACLMessage confirmMsg = new ACLMessage(ACLMessage.CONFIRM);
		Retailer retailer = new Retailer(this.tariff.getCap());
		confirmMsg.setContentObject(retailer);
		confirmMsg.addReceiver(this.homeAgent);
		send(confirmMsg);
	}

	public void handleIform(ACLMessage msg) {
		//Random prices
		int energyWanted = Integer.parseInt(msg.getContent());
		String energyPrice = getCalculatedPrice(energyWanted);
		ACLMessage proposeMsg = new ACLMessage(ACLMessage.PROPOSE);
		proposeMsg.setContent(energyPrice);
		proposeMsg.addReceiver(this.homeAgent);
		System.out.println(this.getLocalName() + " proposes $" + energyPrice + " dollars to sell the energy" );
		send(proposeMsg);
	}

	public void handleAccept(ACLMessage msg) {
		System.out.println(this.getLocalName() + " proposal has been accepted");
	}

	public void handleReject(ACLMessage msg) {
		System.out.println(this.getLocalName() + " proposal has been refused");
	}

	public void handlePropose(ACLMessage msg) {
		int energyWanted = Integer.parseInt(msg.getContent());
		String energyPrice = getCalculatedPrice(energyWanted);
		ACLMessage proposeMsg = new ACLMessage(ACLMessage.PROPOSE);
		proposeMsg.setContent(energyPrice);
		proposeMsg.addReceiver(this.homeAgent);
		System.out.println(this.getLocalName() + " proposes $" + energyPrice + " dollars to sell " + msg.getContent() );
		send(proposeMsg);
	}

}
