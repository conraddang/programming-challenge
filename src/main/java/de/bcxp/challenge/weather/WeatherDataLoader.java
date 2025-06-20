package de.bcxp.challenge.weather;

import de.bcxp.challenge.common.CSVDataLoader;
import de.bcxp.challenge.common.DataLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class WeatherDataLoader implements DataLoader<WeatherData> {
    private final CSVDataLoader csvDataLoader;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public WeatherDataLoader(char separator) {
        this.csvDataLoader = new CSVDataLoader(separator);
    }

    @Override
    public List<WeatherData> loadData(String resourcePath) throws Exception {
        List<WeatherData> dataEntries = new ArrayList<>();
        logger.info("Accessing data from resource '{}'", resourcePath);
        List<Map<String, String>> csvRows = csvDataLoader.parse(resourcePath);

        for (Map<String, String> row : csvRows) {
            extractFields(row).ifPresent(dataEntries::add);
        }
        logger.info("Loaded {} country data entries from resource '{}'", dataEntries.size(), resourcePath);
        return dataEntries;
    }

    @Override
    public Optional<WeatherData> extractFields(Map<String, String> row) {
        try {
            String day = row.get("Day");
            int max = Integer.parseInt(row.get("MxT"));
            int min = Integer.parseInt(row.get("MnT"));
            return Optional.of(new WeatherData(day, max, min));
        } catch (Exception e) {
            logger.warn("Skipping row due error: {}", e.getMessage());
            return Optional.empty();
        }
    }
}
