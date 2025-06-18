package de.bcxp.challenge.weather;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReaderHeaderAware;
import com.opencsv.CSVReaderHeaderAwareBuilder;
import de.bcxp.challenge.common.CSVDataLoader;
import de.bcxp.challenge.common.DataLoader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class WeatherDataLoader implements DataLoader<WeatherData> {
    private final CSVDataLoader csvDataLoader;

    public WeatherDataLoader(char separator) {
        this.csvDataLoader = new CSVDataLoader(separator);
    }

    @Override
    public List<WeatherData> loadData(String resourcePath) throws Exception {
        List<WeatherData> dataEntries = new ArrayList<>();
        List<Map<String, String>> csvRows = csvDataLoader.parse(resourcePath);

        for (Map<String, String> row : csvRows) {
            extractFields(row).ifPresent(dataEntries::add);
        }
        return dataEntries;
    }

    @Override
    public Optional<WeatherData> extractFields(Map<String, String> row) {
        try {
            String day = row.get("Day").trim();
            int max = Integer.parseInt(row.get("MxT"));
            int min = Integer.parseInt(row.get("MnT"));
            return Optional.of(new WeatherData(day, max, min));
        } catch (Exception e) {
            System.out.println("Skipping row due to invalid number format: " + e.getMessage());
            return Optional.empty();
        }
    }
}
