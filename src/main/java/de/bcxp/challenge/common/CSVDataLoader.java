package de.bcxp.challenge.common;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReaderHeaderAware;
import com.opencsv.CSVReaderHeaderAwareBuilder;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CSVDataLoader {
    private final char separator;

    public CSVDataLoader(char separator) {
        this.separator = separator;
    }

    public List<Map<String, String>> parse(String resourcePath) throws Exception {
        List<Map<String, String>> allRows = new ArrayList<>();
        CSVParser parser = new CSVParserBuilder().withSeparator(separator).build();
        InputStream input = getClass().getClassLoader().getResourceAsStream(resourcePath);
        if (input == null) {
            throw new FileNotFoundException("Resource not found: " + resourcePath);
        }

        try (CSVReaderHeaderAware reader = new CSVReaderHeaderAwareBuilder(new InputStreamReader(input)).withCSVParser(parser).build()) {
            Map<String, String> row;

            while ((row = reader.readMap()) != null) {
                allRows.add(row);
            }
        } catch (Exception e) {
            throw new Exception("Failed to read CSV from: " + resourcePath, e);
        }
        return allRows;
    }
}
