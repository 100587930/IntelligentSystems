package main.java;

	import java.io.*;
	 
	import java.util.List;
	import weka.core.Instances;
	import weka.classifiers.functions.GaussianProcesses;
	import weka.classifiers.evaluation.NumericPrediction;
	import weka.classifiers.timeseries.WekaForecaster;
	import weka.core.converters.ConverterUtils.DataSource;
	
	@SuppressWarnings("unused")
	public class WekaTest {
	 
	  public static void main(String[] args) {
	    try {
	    
	      //find data in files
	      DataSource source = new DataSource("/IntelligentSystems/src/lib/Electricity_P_DS.arff");
	      
	      //load data
	      Instances data = source.getDataSet();
	 
	      // new forecaster
	      WekaForecaster forecaster = new WekaForecaster();
	 
	      // set the targets we want to forecast. This method calls
	      // setFieldsToLag() on the lag maker object for us
	      forecaster.setFieldsToForecast("FGE");
	 
	      
	      forecaster.setBaseForecaster(new GaussianProcesses());
	 
	      
	      forecaster.getTSLagMaker().setTimeStampField("Hours"); // hour time stamp
	      forecaster.getTSLagMaker().setMinLag(1);
	      forecaster.getTSLagMaker().setMaxLag(24); // hourly data
	 
	      // build the model
	      forecaster.buildForecaster(data, System.out);
	 
	      // prime the forecaster with enough recent historical data
	      // to cover up to the maximum lag. In our case, we could just supply
	      // the 12 most recent historical instances, as this covers our maximum
	      // lag period
	      forecaster.primeForecaster(data);
	 
	      // forecast for 12 units (months) beyond the end of the
	      // training data
	      List<List<NumericPrediction>> forecast = forecaster.forecast(24, System.out);
	 
	      // output the predictions. Outer list is over the steps; inner list is over
	      // the targets
	      for (int i = 0; i < 24; i++) {
	        List<NumericPrediction> predsAtStep = forecast.get(i);
	        for (int j = 0; j < 2; j++) {
	          NumericPrediction predForTarget = predsAtStep.get(j);
	          System.out.print("" + predForTarget.predicted() + " ");
	        }
	        System.out.println();
	      }
	 
	      // we can continue to use the trained forecaster for further forecasting
	      // by priming with the most recent historical data (as it becomes available).
	      // At some stage it becomes prudent to re-build the model using current
	      // historical data.
	 
	    } catch (Exception ex) {
	      ex.printStackTrace();
	    }
	  }
}
