package de.bcxp.challenge.country;

public class CountryData {
    private final String name;
    private final int population;
    private final int area;

    public CountryData(String name, int population, int area) {
        this.name = name;
        this.population = population;
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public int getArea() {
        return area;
    }

    public int getPopulationDensity() {
        return population/area;
    }
}
