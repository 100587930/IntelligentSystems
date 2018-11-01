package utils;

public class Tariffs {
	
	public static String[] getTariffs() {
		String[] tariffs = new String[3];
		tariffs[0] = Constants.FIXED_TARIFF;
		tariffs[1] = Constants.INCREASE_VOLUME_TARIFF;
		tariffs[2] = Constants.VOLUME_TARIFF;
		return tariffs;
	}
	
}
