package com.kodilla.good.patterns.flights;

import java.util.Set;

public class FlightFinder {
    private final FlightDatabase flightDatabase;

    public FlightFinder(FlightDatabase flightDatabase) {
        this.flightDatabase = flightDatabase;
    }

    public Set<Flight> findFlightsFromCity(String sourceCity) {
        return flightDatabase.findFlightsFromCity(sourceCity);
    }

    public Set<Flight> findFlightsToCity(String destinationCity) {
        return flightDatabase.findFlightsToCity(destinationCity);
    }

    public Set<Flight> findFlightsViaCity(String sourceCity, String viaCity, String destinationCity) {
        return flightDatabase.findFlightsViaCity(sourceCity, viaCity, destinationCity);
    }

    public void displayFlightsFromCity(String sourceCity) {
        Set<Flight> flightsFromCity = findFlightsFromCity(sourceCity);

        System.out.println("\nFlights from " + sourceCity + ":");
        for (Flight flight : flightsFromCity) {
            System.out.println(flight.originCity() + " -> " + flight.destinationCity());
        }
    }

    public void displayFlightsToCity(String destinationCity) {
        Set<Flight> flightsToCity = findFlightsToCity(destinationCity);

        System.out.println("\nFlights to " + destinationCity + ":");
        for (Flight flight : flightsToCity) {
            System.out.println(flight.originCity() + " -> " + flight.destinationCity());
        }
    }

    public void displayFlightsViaCity(String sourceCity, String viaCity, String destinationCity) {
        Set<Flight> flightsViaCity = findFlightsViaCity(sourceCity, viaCity, destinationCity);

        System.out.println("\nFlights from " + sourceCity + " to " + destinationCity + " via " + viaCity + ":");
        for (Flight flight : flightsViaCity) {
            System.out.println(flight.originCity() + " -> " + flight.destinationCity());
        }
    }
}