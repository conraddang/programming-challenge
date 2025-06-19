package de.bcxp.challenge.weather;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class WeatherServiceTest {

    @Test
    void findDayWithSmallestTempSpread() {
        WeatherService service = new WeatherService();
        List<WeatherData> days = Arrays.asList(
                new WeatherData("1", 30, 20),  // Spread: 10
                new WeatherData("2", 25, 10),  // Spread: 15
                new WeatherData("3", 22, 18)   // Spread: 4
        );

        WeatherData result = service.findDayWithSmallestTempSpread(days);
        assertEquals("3", result.getDay());
    }

    @Test
    void findDayWithSmallestTempSpread_emptyList() {
        WeatherService service = new WeatherService();
        List<WeatherData> days = List.of();

        WeatherData result = service.findDayWithSmallestTempSpread(days);
        assertNull(result);
    }
}