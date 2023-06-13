package com.kodilla.good.patterns.flights;

public class Application {
    public static void main(String[] args) {

        FlightDatabase flightDatabase = new FlightDatabase();
        FlightFinder flightFinder = new FlightFinder(flightDatabase);

        String sourceCity = "Gdańsk";
        String destinationCity = "Wrocław";

        flightFinder.displayFlightsFromCity(sourceCity);
        flightFinder.displayFlightsToCity(destinationCity);
        flightFinder.displayFlightsViaCity(sourceCity, "Warszawa", destinationCity);
    }
}
