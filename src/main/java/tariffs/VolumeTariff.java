package tariffs;

public class VolumeTariff extends Tariff {
	
	public VolumeTariff(float pricePerKW, float energyCap) {
		super(pricePerKW, energyCap);
	}
	
	public float calculateOffer(float energyWanted) {
		float price = 0;
		energyWanted = energyWanted > this.energyCap ? this.energyCap : energyWanted;
		if(energyWanted <= 5) {
			price = this.calculatePrice(8, energyWanted);
		} else if (energyWanted > 5 && energyWanted <= 10) {
			price = this.calculatePrice(6, energyWanted);
		} else if (energyWanted > 10 && energyWanted <= 20) {
			price = this.calculatePrice(2, energyWanted);
		} else if (energyWanted > 20) {
			price = this.pricePerKW * energyWanted;
		}
		return price;
	}
	
	public float calculatePrice(float penaltyRate, float energyWanted) {
		return this.pricePerKW * penaltyRate * energyWanted;
	}
}
