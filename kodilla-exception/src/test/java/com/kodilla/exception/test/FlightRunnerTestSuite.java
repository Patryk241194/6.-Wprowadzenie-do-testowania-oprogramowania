package com.kodilla.exception.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FlightRunnerTestSuite {

    @Test
    public void testFindFlight() {
        // given
        FlightRunner flightRunner = new FlightRunner();

        // when & then
//        1) Airport with true to airport with true
//        2) Departure and landing at the same airport
//        3) Airport with true to airport with false
//        4) Airport with false to airport with false
//        5) Two airports that are not on the map of airports

        assertAll(
                () -> assertDoesNotThrow(() -> flightRunner.findFlight(new Flight("ATL", "PEK"))),
                () -> assertThrows(RouteNotFoundException.class, () -> flightRunner.findFlight(new Flight("LAX", "LAX"))),
                () -> assertThrows(RouteNotFoundException.class, () -> flightRunner.findFlight(new Flight("ATL", "CAN"))),
                () -> assertThrows(RouteNotFoundException.class, () -> flightRunner.findFlight(new Flight("CDG", "PEK"))),
                () -> assertThrows(RouteNotFoundException.class, () -> flightRunner.findFlight(new Flight("BGT", "FGR")))
        );
    }
}
