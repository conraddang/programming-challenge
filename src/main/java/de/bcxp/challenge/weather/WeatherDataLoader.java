package de.bcxp.challenge.weather;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReaderHeaderAware;
import com.opencsv.CSVReaderHeaderAwareBuilder;
import de.bcxp.challenge.common.DataLoader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WeatherDataLoader implements DataLoader<WeatherData> {


    @Override
    public List<WeatherData> loadData(String resourcePath) throws Exception {
        List<WeatherData> dataEntries = new ArrayList<>();
        CSVParser parser = new CSVParserBuilder().withSeparator(',').build();
        InputStream input = getClass().getClassLoader().getResourceAsStream(resourcePath);

        try (CSVReaderHeaderAware reader = new CSVReaderHeaderAwareBuilder(new InputStreamReader(input)).withCSVParser(parser).build()) {
            Map<String, String> row;

            while ((row = reader.readMap()) != null) {
                try {
                    String day = row.get("Day").trim();
                    int max = Integer.parseInt(row.get("MxT"));
                    int min = Integer.parseInt(row.get("MnT"));
                    dataEntries.add(new WeatherData(day, max, min));
                } catch (Exception e) {
                    System.out.println("Exception: " + e);
                }
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        return dataEntries;
    }
}
