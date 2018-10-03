package controllers;

import jade.core.Runtime;

import java.util.ArrayList;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.*;

public class MainController {

	private AgentContainer mainContainer;
	private AgentContainer homeContainer;
	private AgentContainer applianceContainer;
	private AgentContainer retailerContainer;

	public MainController() {
		this.setupContainers();
		this.startAgents();
		// Here we will instantiate the GUI so we can receive dynamic settings
	}

	private void startAgents() {
		try {
			this.startRMAAgent();
			this.startHomeAgent();
			this.startApplianceAgents();
			this.startRetailerAgents();
		} catch (StaleProxyException e) {
			e.printStackTrace();
		}
	}

	private void startRetailerAgents() throws StaleProxyException {
		// TODO: create 3 RAs
		Object[][] retailerArguments = new Object[2][2]; // will be given by the GUI
		ArrayList<String> retailerAgentNames = new ArrayList<String>(); // will be given by the GUI
		retailerAgentNames.add("Retailer Agent 1");
		retailerAgentNames.add("Retailer Agent 2");
		for(int i = 0; i < retailerArguments.length; i++) {
			AgentController retailerAgent = this.retailerContainer.createNewAgent(retailerAgentNames.get(i),
					"agents.RetailerAgent", retailerArguments);
			retailerAgent.start();
		}
		
	}

	private void startApplianceAgents() throws StaleProxyException {
		// TODO: create 5 AAs
		Object[][] applianceArguments = new Object[2][2]; // will be given by the GUI
		ArrayList<String> applianceAgentName = new ArrayList<String>(); // will be given by the GUI
		applianceAgentName.add("Dishwasher");
		applianceAgentName.add("Fridge");
		for(int i = 0; i < applianceArguments.length; i++) {
			AgentController applianceAgent = this.applianceContainer.createNewAgent(applianceAgentName.get(i),
					"agents.ApplianceAgent", applianceArguments);
			applianceAgent.start();	
		}
	}

	private void startHomeAgent() throws StaleProxyException {
		Object[][] homeArguments = new Object[1][2]; // will be given by the GUI
		String homeAgentName = "Home Agent"; // will be given by the GUI
		AgentController homeAgent = this.homeContainer.createNewAgent(homeAgentName, "agents.HomeAgent", homeArguments);
		homeAgent.start();
	}

	private void startRMAAgent() throws StaleProxyException {
		AgentController rma;
		rma = this.mainContainer.createNewAgent("rma", "jade.tools.rma.rma", new Object[0]);
		rma.start();
	}

	private void setupContainers() {
		Runtime runtime = Runtime.instance();
		runtime.setCloseVM(true);

		// Main container
		Profile mainProfile = new ProfileImpl(null, 1200, "main");
		this.mainContainer = runtime.createMainContainer(mainProfile);

		// Home container
		ProfileImpl homeProfile = new ProfileImpl(null, 1200, "home");
		homeProfile.setParameter(Profile.CONTAINER_NAME, "Home-Container");
		this.homeContainer = runtime.createAgentContainer(homeProfile);

		// Appliances container
		ProfileImpl appliancesProfile = new ProfileImpl(null, 1200, "appliances");
		appliancesProfile.setParameter(Profile.CONTAINER_NAME, "Appliances-Container");
		this.applianceContainer = runtime.createAgentContainer(appliancesProfile);

		// Retailers container
		ProfileImpl retailersProfile = new ProfileImpl(null, 1200, "retailers");
		retailersProfile.setParameter(Profile.CONTAINER_NAME, "Retailers-Container");
		this.retailerContainer = runtime.createAgentContainer(retailersProfile);
	}
}
