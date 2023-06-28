package com.kodilla.spring.fibonacci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciTestSuite {

    @Test
    void testCalculateFibonacci() {
        // Given
        Fibonacci fibonacci = new Fibonacci();
        // When
        int expectedResult = fibonacci.calculateFibonacci(8);
        // Then
        System.out.println(expectedResult);
        assertEquals(expectedResult,21);
    }

    @Test
    void testCalculateFibonacciRecursive() {
        // Given
        Fibonacci fibonacci = new Fibonacci();
        // When
        int expectedResult = fibonacci.calculateFibonacciRecursive(8);
        // Then
        System.out.println(expectedResult);
        assertEquals(expectedResult,21);
    }
}
