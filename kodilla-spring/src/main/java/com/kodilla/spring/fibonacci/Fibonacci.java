package com.kodilla.spring.fibonacci;

public class Fibonacci {

    public int calculateFibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("'n' must be a non-negative integer.");
        }

        if (n <= 1) {
            return n;
        }

        int previousValue = 0;
        int currentValue = 1;

        for (int i = 2; i <= n; i++) {
            int nextValue = currentValue + previousValue;
            previousValue = currentValue;
            currentValue = nextValue;
        }

        return currentValue;
    }

    public int calculateFibonacciRecursive(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("'n' must be a non-negative integer.");
        }

        if (n <= 1) {
            return n;
        }

        return fibonacciSequence(n);
    }

    private int fibonacciSequence(int n) {
        if (n <= 1) {
            return n;
        }

        return fibonacciSequence(n - 1) + fibonacciSequence(n - 2);
    }
}

