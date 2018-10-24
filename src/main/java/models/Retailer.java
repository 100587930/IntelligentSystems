package models;

import java.io.Serializable;

import jade.core.AID;

public class Retailer implements Serializable {

	private float cap;
	private float price;
	private float energyDemand;
	private AID aid;
	private int round = 0;
	
	public Retailer(float cap) {
		this.cap = cap;
	}
	
	public int getRound() {
		return this.round;
	}
	
	public void incrementRound() {
		this.round++;
	}
	
	public AID getAID() {
		return this.aid;
	}
	
	public AID setAID(AID aid) {
		return this.aid = aid;
	}
	
	public float getEnergyDemand() {
		return this.energyDemand;
	}
	
	public void setEnergyDemand(float energyDemand) {
		this.energyDemand = energyDemand;
	}
	
	public float getCap() {
		return this.cap;
	}
	
	public float getPrice() {
		return this.price;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
}
