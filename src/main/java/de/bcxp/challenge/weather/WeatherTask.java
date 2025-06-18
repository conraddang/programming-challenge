package de.bcxp.challenge.weather;

import java.util.List;

public class WeatherTask {
    private final static String RESOURCE_PATH = "de/bcxp/challenge/weather.csv";
    private final WeatherDataLoader weatherDataLoader = new WeatherDataLoader();
    private final WeatherService weatherService = new WeatherService();

    public String execute() {
        List<WeatherData> dataEntries =  weatherDataLoader.loadData(RESOURCE_PATH);
        for (WeatherData dataEntry : dataEntries) {
            System.out.println("Day: " + dataEntry.getDay() + " MaxT: " + dataEntry.getMaxTemp() + " MinT: " + dataEntry.getMinTemp() + " Spread: " + dataEntry.getTempSpread());
        }
        return weatherService.findDayWithSmallestTempSpread(dataEntries).getDay();
    }
}
