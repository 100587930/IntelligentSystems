package tariffs;

public interface TariffInterface {

	float calculateOffer(float energyWanted);

	float calculatePrice(float penaltyRate, float energyWanted);

	float getCap();

}
