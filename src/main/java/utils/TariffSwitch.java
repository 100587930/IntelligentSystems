package utils;

import tariffs.FixedTariff;
import tariffs.IncreaseVolumeTariff;
import tariffs.Tariff;
import tariffs.VolumeTariff;

public class TariffSwitch {
	
	public static Tariff getTariff(Object[] retailerArguments) {
		
		String tariffName = (String) retailerArguments[0];
		float tariffCap = (float) retailerArguments[1];
		float tariffBasePrice = (float) retailerArguments[2];
		Tariff tariff = null;
		
		switch(tariffName) {
		case Constants.FIXED_TARIFF:
			tariff = new FixedTariff(tariffBasePrice, tariffCap);
			break;
		case Constants.VOLUME_TARIFF:
			tariff = new VolumeTariff(tariffBasePrice, tariffCap);
			break;
		case Constants.INCREASE_VOLUME_TARIFF:
			tariff = new IncreaseVolumeTariff(tariffBasePrice, tariffCap);
			break;
		}
		return tariff;
	}
	
}
