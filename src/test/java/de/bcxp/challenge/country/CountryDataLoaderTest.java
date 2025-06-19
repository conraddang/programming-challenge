package de.bcxp.challenge.country;

import org.junit.jupiter.api.Test;
import java.util.Map;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

public class CountryDataLoaderTest {

    @Test
    void extractFields_validData() {
        CountryDataLoader loader = new CountryDataLoader(';');
        Map<String, String> row = Map.of(
                "Name", "Testland",
                "Population", "10.000.000",
                "Area (km²)", "1000"
        );

        Optional<CountryData> result = loader.extractFields(row);

        assertTrue(result.isPresent());
        assertEquals("Testland", result.get().getName());
        assertEquals(10000000, result.get().getPopulation());
        assertEquals(1000, result.get().getArea());
    }

    @Test
    void parsePopulation_withComma() {
        CountryDataLoader loader = new CountryDataLoader(';');
        int result = loader.parsePopulation("12,345");
        assertEquals(12, result);
    }

    @Test
    void parsePopulation_withDots() {
        CountryDataLoader loader = new CountryDataLoader(';');
        int result = loader.parsePopulation("12.345.678");
        assertEquals(12345678, result);
    }
}