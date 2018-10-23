package tariffs;

public interface TariffInterface {

	int calculateOffer(int energyWanted);
	int calculatePrice(int penaltyRate, int energyWanted);
	int getCap();
	
}
