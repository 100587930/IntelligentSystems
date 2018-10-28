package main.java.tariffs;

public class Tariff implements TariffInterface {

	protected float pricePerKW;
	protected float energyCap;

	public Tariff(float pricePerKW, float energyCap) {
		this.pricePerKW = pricePerKW;
		this.energyCap = energyCap;
	}

	@Override
	public float calculateOffer(float energyWanted) {
		return 0;
	}

	@Override
	public float calculatePrice(float penaltyRate, float energyWanted) {
		return this.pricePerKW * penaltyRate * energyWanted;
	}

	@Override
	public float getCap() {
		return this.energyCap;
	}

}
