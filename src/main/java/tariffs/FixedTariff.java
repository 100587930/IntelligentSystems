package main.java.tariffs;

public class FixedTariff extends Tariff {

	public FixedTariff(float pricePerKW, float energyCap) {
		super(pricePerKW, energyCap);
	}

	public float calculateOffer(float energyWanted) {
		energyWanted = energyWanted > this.energyCap ? this.energyCap : energyWanted;
		return this.calculatePrice(5, energyWanted);
	}

	public float calculatePrice(float penaltyRate, float energyWanted) {
		return this.pricePerKW * penaltyRate * energyWanted;
	}

}
