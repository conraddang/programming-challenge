package de.bcxp.challenge.country;

import de.bcxp.challenge.common.CSVDataLoader;
import de.bcxp.challenge.common.DataLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CountryDataLoader implements DataLoader<CountryData> {
    private final CSVDataLoader csvDataLoader;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public CountryDataLoader(char separator) {
        this.csvDataLoader = new CSVDataLoader(separator);
    }

    @Override
    public List<CountryData> loadData(String resourcePath) throws Exception {
        List<CountryData> dataEntries = new ArrayList<>();
        logger.info("Accessing data from resource '{}'", resourcePath);
        List<Map<String, String>> csvRows = csvDataLoader.parse(resourcePath);

        for (Map<String, String> row : csvRows) {
            extractFields(row).ifPresent(dataEntries::add);
        }
        logger.info("Loaded {} weather data entries from resource '{}'", dataEntries.size(), resourcePath);
        return dataEntries;
    }

    @Override
    public Optional<CountryData> extractFields(Map<String, String> row) {
        try {
            String name = row.get("Name").trim();
            double population = Double.parseDouble(row.get("Population").trim().replace(".", "").replace(",", "."));
            double area = Double.parseDouble(row.get("Area (km²)").trim());
            return Optional.of(new CountryData(name, population, area));
        } catch (Exception e) {
            logger.warn("Skipping row due to error: {}", e.getMessage());
            return Optional.empty();
        }
    }
}
