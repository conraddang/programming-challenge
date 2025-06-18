package de.bcxp.challenge;

import de.bcxp.challenge.country.CountryTask;
import de.bcxp.challenge.weather.WeatherTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String... args) {

        // Your preparation code …
        try {
            String dayWithSmallestTempSpread = new WeatherTask().execute();     // Your day analysis function call …
            System.out.printf("Day with smallest temperature spread: %s%n", dayWithSmallestTempSpread);

            String countryWithHighestPopulationDensity = new CountryTask().execute(); // Your population density analysis function call …
            System.out.printf("Country with highest population density: %s%n", countryWithHighestPopulationDensity);
        } catch (Exception e) {
            logger.error("Error occurred in App main: {}", e.getMessage());
            System.exit(1);
        }
    }
}
