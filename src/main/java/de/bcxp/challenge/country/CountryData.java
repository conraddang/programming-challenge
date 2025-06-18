package de.bcxp.challenge.country;

public class CountryData {
    private final String name;
    private final double population;
    private final double area;

    public CountryData(String name, double population, double area) {
        this.name = name;
        this.population = population;
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public double getPopulation() {
        return population;
    }

    public double getArea() {
        return area;
    }

    public double getPopulationDensity() {
        return population/area;
    }
}
