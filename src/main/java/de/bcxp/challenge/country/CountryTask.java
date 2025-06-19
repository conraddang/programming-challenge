package de.bcxp.challenge.country;

import de.bcxp.challenge.common.Task;
import de.bcxp.challenge.weather.WeatherData;
import de.bcxp.challenge.weather.WeatherDataLoader;
import de.bcxp.challenge.weather.WeatherService;

import java.util.List;

public class CountryTask implements Task {
    private final static String RESOURCE_PATH = "de/bcxp/challenge/countries.csv";
    private final CountryDataLoader countyDataLoader = new CountryDataLoader(';');
    private final CountryService countryService = new CountryService();

    @Override
    public String execute() throws Exception {
        List<CountryData> dataEntries =  countyDataLoader.loadData(RESOURCE_PATH);
        for (CountryData data : dataEntries) {
            System.out.println("Name: " + data.getName() + ", Population: " + data.getPopulation() + ", Area: " + data.getArea() + ", Population Density: " + data.getPopulationDensity());
        }
        CountryData result = countryService.findCountryWithHighestPopulationDensity(dataEntries);

        if (result == null) {
            return "No country found";
        }
        return result.getName();
    }
}

