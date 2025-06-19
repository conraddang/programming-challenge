package de.bcxp.challenge.country;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CountryDataTest {

    @Test
    void getPopulationDensity_calculation() {
        CountryData country = new CountryData("Denseland", 1000000, 500);
        assertEquals(2000, country.getPopulationDensity());
    }
}