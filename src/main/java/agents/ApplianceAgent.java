package main.java.agents;

import main.java.behaviours.ApplianceCyclicBehaviour;
import main.java.behaviours.ApplianceTickerBehaviour;
import main.java.behaviours.RetailerCyclicBehaviour;
import main.java.forecasters.Forcaster;
import main.java.models.Appliance;
import main.java.models.Retailer;

import java.util.HashMap;
import java.util.Map.Entry;

import jade.core.*;
import jade.lang.acl.ACLMessage;
import main.java.utils.Constants;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import main.java.behaviours.HomeCyclicBehaviour;
import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import jade.util.leap.ArrayList;
import main.java.models.Appliance;
import main.java.models.Retailer;
import main.java.utils.Constants;

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
		// TODO: change it later with the real usage
		this.energyUsage = this.energyExpected;
		return this.energyUsage;
	}

}
