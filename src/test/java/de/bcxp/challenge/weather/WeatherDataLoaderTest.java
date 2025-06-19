package de.bcxp.challenge.weather;

import org.junit.jupiter.api.Test;
import java.util.Map;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

public class WeatherDataLoaderTest {

    @Test
    void extractFields_validData() {
        WeatherDataLoader loader = new WeatherDataLoader(',');
        Map<String, String> row = Map.of(
                "Day", "5",
                "MxT", "25",
                "MnT", "15"
        );

        Optional<WeatherData> result = loader.extractFields(row);

        assertTrue(result.isPresent());
        assertEquals("5", result.get().getDay());
        assertEquals(25, result.get().getMaxTemp());
        assertEquals(15, result.get().getMinTemp());
    }

}