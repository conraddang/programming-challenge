package de.bcxp.challenge.country;

import java.util.Comparator;
import java.util.List;

public class CountryService {
    public CountryData findCountryWithHighestPopulationDensity(List<CountryData> dataEntries) {
        return dataEntries.stream()
                .max(Comparator.comparingDouble(CountryData::getPopulationDensity))
                .orElse(null);
    }
}
