package de.bcxp.challenge.country;

import de.bcxp.challenge.common.Task;

import java.util.List;

public class CountryTask implements Task {
    private final static String RESOURCE_PATH = "de/bcxp/challenge/countries.csv";
    private final CountryDataLoader countyDataLoader = new CountryDataLoader(';');
    private final CountryService countryService = new CountryService();

    @Override
    public String execute() throws Exception {
        List<CountryData> dataEntries =  countyDataLoader.loadData(RESOURCE_PATH);
        CountryData result = countryService.findCountryWithHighestPopulationDensity(dataEntries);

        if (result == null) {
            return "No country found";
        }
        return result.getName();
    }
}

