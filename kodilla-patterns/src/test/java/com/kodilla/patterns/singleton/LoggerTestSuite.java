package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoggerTestSuite {

    private static Logger logger;

    @Test
    void getLastLog() {
        //Given
        logger = Logger.INSTANCE;
        //When
        logger.log("Application started");
        logger.log("User logged in");
        String result = logger.getLastLog();
        //Then
        assertEquals("User logged in", result);
    }
}
