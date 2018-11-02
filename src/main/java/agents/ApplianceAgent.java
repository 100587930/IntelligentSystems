package agents;

import behaviours.ApplianceCyclicBehaviour;
import behaviours.ApplianceTickerBehaviour;
import behaviours.RetailerCyclicBehaviour;
import forecasters.Forcaster;
import models.Appliance;
import models.Retailer;

import java.util.HashMap;
import java.util.Map.Entry;

import jade.core.*;
import jade.lang.acl.ACLMessage;
import utils.Constants;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import behaviours.HomeCyclicBehaviour;
import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import jade.util.leap.ArrayList;
import models.Appliance;
import models.Retailer;
import utils.Constants;

@SuppressWarnings("serial")
public class ApplianceAgent extends Agent {

	private float energyExpected; // TODO: Get information from data set
	private float energyUsage;
	private AID homeAgent = Constants.HOME_AGENT_AID;
	private long mSecondsToInform = 3000; // change for different frequencies
	private HashMap<AID, Appliance> applianceAgents = new HashMap<AID, Appliance>();
	private Forcaster energyforcaster;
	protected void setup() {
		this.subscribe();
		
		for (Entry<AID, Appliance> entry : this.applianceAgents.entrySet()) {
			int iend = entry.getKey().getName().indexOf("@");
			String CurrentAgent = entry.getKey().getName().substring(0, iend);
			
			if(CurrentAgent == "Dishwasher"){
				energyforcaster = new Forcaster("DWE");
				
			}
			else if(CurrentAgent == "Heater") {
				
				energyforcaster = new Forcaster("FRE");
			}
			else if(CurrentAgent == "Fridge") {
				
				energyforcaster = new Forcaster("FGE");
			}
			else if(CurrentAgent == "TV") {
				
				energyforcaster = new Forcaster("TVE");
			}
			else if(CurrentAgent == "Washing Machine") {
				
				energyforcaster = new Forcaster("CWE");
			}
			
		}
		
		
		
		this.setExpectedUsage(energyforcaster.getPrediction()); 

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

	public void handleInform(ACLMessage msg) {
		ACLMessage response = new ACLMessage(ACLMessage.REQUEST);
		float energyGiven = Float.parseFloat(msg.getContent());
		float energyMissing = this.getEnergyUsage() - energyGiven > 0 ? this.getEnergyUsage() - energyGiven : 0;
		response.setContent(Float.toString(energyMissing));
		response.addReceiver(this.homeAgent);
		send(response);
	}

	public float getEnergyUsage() {
		this.energyUsage = energyforcaster.getPrediction();
		return this.energyUsage;
	}

}
