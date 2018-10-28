package main.java.utils;

import jade.core.AID;

//Insert all strings here
public class Constants {

	public static final String APPLIANCE_AGENT = "Appliance Agent";
	public static final String HOME_AGENT = "Home Agent";
	public static final String RETAILER_AGENT = "Retailer Agent";
	public static final int APPLIANCE_AGENTS_COUNT = 3;
	public static final int RETAILER_AGENTS_COUNT = 3;
	public static final String FIXED_TARIFF = "Fixed Tariff";
	public static final String VOLUME_TARIFF = "Volume Tariff";
	public static final String INCREASE_VOLUME_TARIFF = "Increase Volume Tariff";

	public static final AID HOME_AGENT_AID = new AID(Constants.HOME_AGENT, AID.ISLOCALNAME);

}
