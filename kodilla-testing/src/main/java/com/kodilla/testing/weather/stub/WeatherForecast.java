package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures){
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast(){
        Map<String, Double> resultMap =  new HashMap<>();

        for (Map.Entry<String, Double> temperature :
           temperatures.getTemperatures().entrySet()){
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
        }
        return resultMap;
    }

    public Double calculateAverage(){
        double sum = 0;
        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()){
            sum += temperature.getValue();
        }
        double avg = sum / temperatures.getTemperatures().size();
        return avg;
    }

    public Double calculateMedian(){
        List<Double> temperaturesList = new ArrayList<>(temperatures.getTemperatures().values());
        Collections.sort(temperaturesList);
        int med = temperaturesList.size() / 2;
        double median = temperaturesList.get(med);
        return median;
    }

}
