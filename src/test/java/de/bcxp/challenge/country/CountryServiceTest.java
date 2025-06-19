package de.bcxp.challenge.country;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class CountryServiceTest {

    @Test
    void findCountryWithHighestPopulationDensity() {
        CountryService service = new CountryService();
        List<CountryData> countries = Arrays.asList(
                new CountryData("LowDensity", 1000, 1000),  // Density: 1
                new CountryData("HighDensity", 9000, 3000), // Density: 3
                new CountryData("MediumDensity", 4000, 2000) // Density: 2
        );

        CountryData result = service.findCountryWithHighestPopulationDensity(countries);
        assertEquals("HighDensity", result.getName());
    }

    @Test
    void findCountryWithHighestPopulationDensity_emptyList() {
        CountryService service = new CountryService();
        List<CountryData> countries = List.of();

        CountryData result = service.findCountryWithHighestPopulationDensity(countries);
        assertNull(result);
    }
}