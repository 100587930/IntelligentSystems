package forecasters;

import java.util.List;

import weka.classifiers.evaluation.NumericPrediction;
import weka.classifiers.functions.GaussianProcesses;
import weka.classifiers.timeseries.WekaForecaster;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class Forcaster {

	private int i = 0;
	private int j = 0;
	private double a;
	private double b;
	private float prediction;
	
	private List<List<NumericPrediction>> forecast;
	
	
	public Forcaster(String name) {
		try {
			   
		      //find data in files
			String path = weka.core.WekaPackageManager.PACKAGES_DIR.toString()
					+ File.separator + "IntelligentSystems" + File.separator + "src" + File.separator + "lib" + File.separator + "Electricity_P_DS.arff";
			
			Instances data = new Instances(new BufferedReader(new FileReader(path)));
			
		    //  DataSource source = new DataSource("/IntelligentSystems/src/lib/Electricity_P_DS.arff");
		      
		      //load data
		    //  Instances data = source.getDataSet();
		 
		      // new forecaster
		      WekaForecaster forecaster = new WekaForecaster();
		 
		      // set the target we want to forecast.
		      forecaster.setFieldsToForecast(name);
		 
		      forecaster.setBaseForecaster(new GaussianProcesses());
		 
		      
		      forecaster.getTSLagMaker().setTimeStampField("Hours"); // hour time stamp
		      
			      // build the model
		      forecaster.buildForecaster(data, System.out);
		 
		      
		      forecaster.primeForecaster(data);
		      // forecast
		 
		    } catch (Exception ex) {
		      ex.printStackTrace();
		    }
		  }
	
	
	
	public float getPrediction() {
		
		List<NumericPrediction> predsAtStep = forecast.get(i);
		
		NumericPrediction predForTarget = predsAtStep.get(j);
		a = predForTarget.predicted();
		i++;
		j++;
		List<NumericPrediction> predsAtStep2 = forecast.get(i);
		NumericPrediction predForTarget2 = predsAtStep2.get(j);
		b = predForTarget2.predicted();
		
		prediction = (float) (a + b);
		j = 0;
		i++;
		return prediction;
	}

}
