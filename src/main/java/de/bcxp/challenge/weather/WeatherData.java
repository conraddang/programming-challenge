package de.bcxp.challenge.weather;

public class WeatherData {

    private final String day;
    private final int maxTemp;
    private final int minTemp;

    public WeatherData(String day, int maxTemp, int minTemp) {
        this.day = day;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
    }

    public String getDay() {
        return day;
    }

    public int getMaxTemp() {
        return maxTemp;
    }

    public int getMinTemp() {
        return minTemp;
    }

    public int getTempSpread() {
        return maxTemp - minTemp;
    }

}
