package controllers;

import jade.core.Runtime;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Gui.Model;
import Gui.SettingModel;
import Gui.SettingView;
import Gui.View;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.*;
import utils.Constants;

public class MainController {

	private AgentContainer mainContainer;
	private AgentContainer homeContainer;
	private AgentContainer applianceContainer;
	private AgentContainer retailerContainer;

	private float retailersCap = 25; 		//default values
	private float retailersBasePrice = 18; 
	private float defaultMaxPrice = 10000;
	
	public SettingModel model;
	
	public MainController() {
	    final SettingView view = new SettingView();
	    model = new SettingModel(view);
	    view.frame.setVisible(true);
	    
		

		
	    view.UpdateValuesButton().addActionListener(new ActionListener() {//actions to do when update button is pressed
	    	 public void actionPerformed(ActionEvent e) {
	    			setupContainers();
	    			startAgents();
	    			 view.frame.setVisible(false);
	    	 }});
	   
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
		ArrayList<String> retailerAgentNames = new ArrayList<String>();
		Object[][] retailerArguments = new Object[model.getRetailAgents()][3];
		for(int r = 0; r < model.getRetailAgents();){
			retailerArguments[r][0] = Constants.FIXED_TARIFF;
			retailerArguments[r][1] = model.getRetailerMax();
			retailerArguments[r][2] = model.getRetailerMin();
			retailerAgentNames.add(model.getRetailNames()[r]);
			r++;
		}
		for (int i = 0; i < model.getRetailAgents(); i++) {
			AgentController retailerAgent = this.retailerContainer.createNewAgent(retailerAgentNames.get(i),
					"agents.RetailerAgent", retailerArguments[i]);
			retailerAgent.start();
		}

		}


	private void startApplianceAgents() throws StaleProxyException {
		// TODO: create 5 AAs
		Object[][] applianceArguments = new Object[model.getAplianceAgents()][3];
		ArrayList<String> applianceAgentName = new ArrayList<String>(); // will be given by the GUI
		for(int r = 0; r < model.getAplianceAgents(); r++){
			applianceAgentName.add(model.getAppNames()[r]);
		}
		for (int i = 0; i < model.getAplianceAgents(); i++) {
			AgentController applianceAgent = this.applianceContainer.createNewAgent(applianceAgentName.get(i),
					"agents.ApplianceAgent", applianceArguments);
			applianceAgent.start();
		}
	}

	private void startHomeAgent() throws StaleProxyException {
		Object[] homeArguments = new Object[1]; // will be given by the GUI
		homeArguments[0] = model.getBaseMax(); // default price
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
