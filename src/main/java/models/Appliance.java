package main.java.models;

import jade.util.leap.Serializable;

public class Appliance implements Serializable {

	private float energyExpected;
	private float energyDemand;

	public Appliance(float energyExpected) {
		this.energyExpected = energyExpected;
	}

	public float getEnergyExpected() {
		return this.energyExpected;
	}

	public float getEenergyDemand() {
		return this.energyDemand;
	}

	public void setEnergyDemand(float energyDemand) {
		this.energyDemand = energyDemand;
	}

}
