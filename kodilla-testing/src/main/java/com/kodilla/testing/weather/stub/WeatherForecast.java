package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {

    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();
        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
            // adding 1 celsius degree to current value as a temporary weather forecast
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
        }
        return resultMap;
    }

    public Double calculateAverageTemperature() {
        double sumOfTemperatures = 0;
        int amountOfTemperatures = temperatures.getTemperatures().size();
        if (amountOfTemperatures >= 1) {
            for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
                sumOfTemperatures += temperature.getValue();
            }
            return sumOfTemperatures / amountOfTemperatures;
        } else {
            throw new ArithmeticException("No data to calculate average temperature.");
        }
    }

    public Double calculateMedianTemperature() {
        int amountOfTemperatures = temperatures.getTemperatures().size();
        if (amountOfTemperatures >= 1) {
            List<Double> medianTemperature = new ArrayList<>();
            for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
                medianTemperature.add(temperature.getValue());
            }
            Collections.sort(medianTemperature);
            int middleIndex = medianTemperature.size() / 2;

            if (medianTemperature.size() % 2 == 0) {
                return ((medianTemperature.get(middleIndex - 1) + medianTemperature.get(middleIndex)) / 2);
            } else {
// middleIndex in this case will actually be 'X,5' but int will skip the decimal
                return (medianTemperature.get(middleIndex));
            }
        } else {
            throw new ArithmeticException("No data to calculate median temperature.");
        }
    }
}



