package tariffs;

public class IncreaseVolumeTariff extends Tariff {
	
	public IncreaseVolumeTariff(int pricePerKW, int energyCap) {
		super(pricePerKW, energyCap);
	}
	
	public int calculateOffer(int energyWanted) {
		int price = 0;
		energyWanted = energyWanted > this.energyCap ? this.energyCap : energyWanted;
		if(energyWanted <= 5) {
			price = this.calculatePrice(2, energyWanted);
		} else if (energyWanted > 5 && energyWanted <= 10) {
			price = this.calculatePrice(6, energyWanted);
		} else if (energyWanted > 10 && energyWanted <= 20) {
			price = this.calculatePrice(8, energyWanted);
		} else if (energyWanted > 20) {
			price = this.pricePerKW * energyWanted;
		}
		return price;
	}
	
	public int calculatePrice(int penaltyRate, int energyWanted) {
		return this.pricePerKW * penaltyRate * energyWanted;
	}
	
}
