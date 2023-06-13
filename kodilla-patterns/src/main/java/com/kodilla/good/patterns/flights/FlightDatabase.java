package com.kodilla.good.patterns.flights;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static com.kodilla.good.patterns.flights.ListOfAirports.*;

public class FlightDatabase {

    private final Set<Flight> flights;

    public FlightDatabase() {
        this.flights = new HashSet<>();
        addFlight(GDANSK, WROCLAW);
        addFlight(GDANSK, WARSZAWA);
        addFlight(WARSZAWA, WROCLAW);
        addFlight(KRAKOW, WARSZAWA);
    }

    public void addFlight(String originCity, String destinationCity) {
        Flight flight = new Flight(originCity, destinationCity);
        flights.add(flight);
    }

    public Set<Flight> findFlightsFromCity(String city) {
        return flights.stream()
                .filter(flight -> flight.originCity().equals(city))
                .collect(Collectors.toSet());
    }

    public Set<Flight> findFlightsToCity(String city) {
        return flights.stream()
                .filter(flight -> flight.destinationCity().equals(city))
                .collect(Collectors.toSet());
    }

    public Set<Flight> findFlightsViaCity(String sourceCity, String viaCity, String destinationCity) {
        return flights.stream()
                .filter(flight -> flight.originCity().equals(sourceCity) &&
                        flight.destinationCity().equals(destinationCity))
                .filter(flight -> flights.stream()
                        .anyMatch(f -> f.originCity().equals(viaCity) && f.destinationCity().equals(destinationCity)))
                .collect(Collectors.toSet());
    }
}