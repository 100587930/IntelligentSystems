package tariffs;

public class Tariff implements TariffInterface {

	protected int pricePerKW;
	protected int energyCap;
	
	public Tariff(int pricePerKW, int energyCap) {
		this.pricePerKW = pricePerKW;
		this.energyCap = energyCap;
	}

	@Override
	public int calculateOffer(int energyWanted) {
		return 0;
	}

	@Override
	public int calculatePrice(int penaltyRate, int energyWanted) {
		return this.pricePerKW * penaltyRate * energyWanted;
	}

	@Override
	public int getCap() {
		return this.energyCap;
	}
	
}
