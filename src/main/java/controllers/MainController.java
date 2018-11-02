package controllers;

import jade.core.Runtime;

<<<<<<< HEAD
import java.util.ArrayList;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.*;
import main.java.utils.Constants;
=======
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
import utils.Tariffs;
>>>>>>> master

public class MainController {

	private AgentContainer mainContainer;
	private AgentContainer homeContainer;
	private AgentContainer applianceContainer;
	private AgentContainer retailerContainer;

<<<<<<< HEAD
	private float retailersCap = 25; // get from gui
	private float retailersBasePrice = 18; // get from gui
	private float defaultMaxPrice = 10000;

	public MainController() {
		this.setupContainers();
		this.startAgents();
=======

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
	   
>>>>>>> master
		// Here we will instantiate the GUI so we can receive dynamic settings
	}

	private void startAgents() {
<<<<<<< HEAD
=======
		
		
>>>>>>> master
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
<<<<<<< HEAD
		// TODO: create 3 RAs
		Object[][] retailerArguments = new Object[3][3]; // will be given by the GUI
		retailerArguments[0][0] = Constants.FIXED_TARIFF;
		retailerArguments[1][0] = Constants.INCREASE_VOLUME_TARIFF;
		retailerArguments[2][0] = Constants.VOLUME_TARIFF;
		retailerArguments[0][1] = this.retailersCap;
		retailerArguments[1][1] = this.retailersCap;
		retailerArguments[2][1] = this.retailersCap;
		retailerArguments[0][2] = this.retailersBasePrice;
		retailerArguments[1][2] = this.retailersBasePrice;
		retailerArguments[2][2] = this.retailersBasePrice;
		ArrayList<String> retailerAgentNames = new ArrayList<String>(); // will be given by the GUI
		retailerAgentNames.add("Retailer Agent 1");
		retailerAgentNames.add("Retailer Agent 2");
		retailerAgentNames.add("Retailer Agent 3");
		for (int i = 0; i < retailerArguments.length; i++) {
=======
		ArrayList<String> retailerAgentNames = new ArrayList<String>();
		Object[][] retailerArguments = new Object[model.getRetailAgents()][3];
		String[] tariffs = Tariffs.getTariffs();
		int j = 0;
		for(int r = 0; r < model.getRetailAgents();){
			retailerArguments[r][0] = tariffs[r];
			retailerArguments[r][1] = model.getRetailerMax();
			retailerArguments[r][2] = retailersBasePrice;
			retailerAgentNames.add(model.getRetailNames()[r]);
			r++;
		}
		for (int i = 0; i < model.getRetailAgents(); i++) {
>>>>>>> master
			AgentController retailerAgent = this.retailerContainer.createNewAgent(retailerAgentNames.get(i),
					"agents.RetailerAgent", retailerArguments[i]);
			retailerAgent.start();
		}

<<<<<<< HEAD
	}

	private void startApplianceAgents() throws StaleProxyException {
		Object[][] applianceArguments = new Object[5][5]; // will be given by the GUI
		ArrayList<String> applianceAgentName = new ArrayList<String>(); // will be given by the GUI
		
		applianceAgentName.add("Dishwasher"); //DWE
		applianceAgentName.add("Heater");	//FRE
		applianceAgentName.add("Fridge");	//FGE
		applianceAgentName.add("TV");		//TVE
		applianceAgentName.add("Washing Machine");	//CWE
		
		
		for (int i = 0; i < applianceArguments.length; i++) {
=======
		}


	private void startApplianceAgents() throws StaleProxyException {
		// TODO: create 5 AAs
		Object[][] applianceArguments = new Object[model.getAplianceAgents()][3];
		ArrayList<String> applianceAgentName = new ArrayList<String>(); // will be given by the GUI
		for(int r = 0; r < model.getAplianceAgents(); r++){
			applianceAgentName.add(model.getAppNames()[r]);
		}
		for (int i = 0; i < model.getAplianceAgents(); i++) {
>>>>>>> master
			AgentController applianceAgent = this.applianceContainer.createNewAgent(applianceAgentName.get(i),
					"agents.ApplianceAgent", applianceArguments);
			applianceAgent.start();
		}
	}

	private void startHomeAgent() throws StaleProxyException {
		Object[] homeArguments = new Object[1]; // will be given by the GUI
<<<<<<< HEAD
		homeArguments[0] = this.defaultMaxPrice; // default price
=======
		homeArguments[0] = retailersBasePrice; // default price
>>>>>>> master
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
