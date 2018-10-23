package models;

import java.io.Serializable;

import jade.core.AID;

public class Retailer implements Serializable {

	private int cap;
	private int price;
	private int energyDemand;
	private AID aid;
	
	public Retailer(int cap) {
		this.cap = cap;
	}
	
	public AID getAID() {
		return this.aid;
	}
	
	public AID setAID(AID aid) {
		return this.aid = aid;
	}
	
	public int getEnergyDemand() {
		return this.energyDemand;
	}
	
	public void setEnergyDemand(int energyDemand) {
		this.energyDemand = energyDemand;
	}
	
	public int getCap() {
		return this.cap;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
}
