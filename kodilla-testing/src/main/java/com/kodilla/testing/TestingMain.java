package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        int result1 = calculator.add(4, 3);
        if (result1 == 4 + 3) {
            System.out.println("test nr1 OK");
        } else {
            System.out.println("Error!");
        }

        int result2 = calculator.subtract(7, 2);
        if (result2 == 7 - 2) {
            System.out.println("test nr2 OK");
        } else {
            System.out.println("Error!");
        }

    }
}
