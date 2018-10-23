package tariffs;

public class FixedTariff extends Tariff{

	public FixedTariff(int pricePerKW, int energyCap) {
		super(pricePerKW, energyCap);
	}
	
	public int calculateOffer(int energyWanted) {
		energyWanted = energyWanted > this.energyCap ? this.energyCap : energyWanted;
		return this.calculatePrice(5, energyWanted);
	}
	
	public int calculatePrice(int penaltyRate, int energyWanted) {
		return this.pricePerKW * penaltyRate * energyWanted;
	}
	
}
