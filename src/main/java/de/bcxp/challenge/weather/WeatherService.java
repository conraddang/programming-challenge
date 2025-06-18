package de.bcxp.challenge.weather;

import java.util.Comparator;
import java.util.List;

public class WeatherService {
    public WeatherData findDayWithSmallestTempSpread(List<WeatherData> dataEntries) {
        return dataEntries.stream()
                .min(Comparator.comparingInt(WeatherData::getTempSpread))
                .orElse(null);
    }
}
