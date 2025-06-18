package de.bcxp.challenge.weather;

import de.bcxp.challenge.common.Task;

import java.util.List;

public class WeatherTask implements Task {
    private final static String RESOURCE_PATH = "de/bcxp/challenge/weather.csv";
    private final WeatherDataLoader weatherDataLoader = new WeatherDataLoader();
    private final WeatherService weatherService = new WeatherService();

    @Override
    public String execute() throws Exception {
        List<WeatherData> dataEntries = weatherDataLoader.loadData(RESOURCE_PATH);
//        for (WeatherData dataEntry : dataEntries) {
//            System.out.println("Day: " + dataEntry.getDay() + " MaxT: " + dataEntry.getMaxTemp() + " MinT: " + dataEntry.getMinTemp() + " Spread: " + dataEntry.getTempSpread());
//        }
        return weatherService.findDayWithSmallestTempSpread(dataEntries).getDay();
    }
}
