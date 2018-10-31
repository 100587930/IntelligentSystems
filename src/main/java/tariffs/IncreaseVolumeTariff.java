package tariffs;

public class IncreaseVolumeTariff extends Tariff {

	public IncreaseVolumeTariff(float pricePerKW, float energyCap) {
		super(pricePerKW, energyCap);
	}

	public float calculateOffer(float energyWanted) {
		float price = 0;
		energyWanted = energyWanted > this.energyCap ? this.energyCap : energyWanted;
		if (energyWanted <= 5) {
			price = this.calculatePrice(3, energyWanted);
		} else if (energyWanted > 5 && energyWanted <= 10) {
			price = this.calculatePrice(5, energyWanted);
		} else if (energyWanted > 10 && energyWanted <= 20) {
			price = this.calculatePrice(7, energyWanted);
		} else if (energyWanted > 20) {
			price = this.calculatePrice(9, energyWanted);
		}
		return price;
	}

	public float calculatePrice(float penaltyRate, float energyWanted) {
		return this.pricePerKW * penaltyRate * energyWanted;
	}

}
