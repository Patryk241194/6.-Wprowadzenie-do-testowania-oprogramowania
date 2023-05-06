package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightRunner {

    public void findFlight(Flight flight) throws RouteNotFoundException {
        Map<String, Boolean> mapOfAirports = new HashMap<>();
        mapOfAirports.put("ATL", true);
        mapOfAirports.put("PEK", true);
        mapOfAirports.put("LAX", true);
        mapOfAirports.put("DXB", true);
        mapOfAirports.put("HND", true);
        mapOfAirports.put("ORD", false);
        mapOfAirports.put("PVG", false);
        mapOfAirports.put("CDG", false);
        mapOfAirports.put("DFW", false);
        mapOfAirports.put("CAN", false);

        String origin = flight.getDepartureAirport();
        String destination = flight.getArrivalAirport();

        if (mapOfAirports.containsKey(origin) && mapOfAirports.containsKey(destination) &&
                mapOfAirports.get(origin) && mapOfAirports.get(destination) && !origin.equals(destination)) {
            System.out.println("Departure from " + origin +
                    " to " + destination + " is currently available");
        } else {
            throw new RouteNotFoundException("Departure from " + origin +
                    " to " + destination + " is unavailable");
        }
    }

    public static void main(String[] args) {
        FlightRunner flightRunner = new FlightRunner();


        try {
            flightRunner.findFlight(new Flight("CDG", "PEK"));
        } catch (RouteNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}

