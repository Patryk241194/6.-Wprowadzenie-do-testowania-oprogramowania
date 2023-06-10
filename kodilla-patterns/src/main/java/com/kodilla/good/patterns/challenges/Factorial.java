package com.kodilla.good.patterns.challenges;

public class Factorial {

    public static Integer countFactorial(Integer n) {
        Integer factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }

}
