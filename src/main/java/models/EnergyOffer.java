package main.java.models;

public class EnergyOffer {

	private int price;
	private int cap;

	public EnergyOffer(int price, int cap) {
		this.price = price;
		this.cap = cap;
	}

	public int getPrice() {
		return this.price;
	}

	public int getCap() {
		return this.cap;
	}

}
