package de.bcxp.challenge.weather;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WeatherDataTest {

    @Test
    void getTempSpread_calculation() {
        WeatherData weather = new WeatherData("10", 30, 10);
        assertEquals(20, weather.getTempSpread());
    }

    @Test
    void getTempSpread_negativeValues() {
        WeatherData weather = new WeatherData("15", -5, -15);
        assertEquals(10, weather.getTempSpread());
    }
}