package com.kodilla.exception.test;

public class FirstChallenge {

    public double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException();
        }
        return a / b;
    }

    public int power(double base, double exponent) {
        if (base < 0 || exponent < 0 || base != (int) base || exponent != (int) exponent) {
            throw new IllegalArgumentException();
        }
        int result = 1;
        for (int i = 1; i <= exponent; i++) {
            result *= (int) base;
        }
        return result;
    }


    /**
     * This main can throw an ArithmeticException!!!
     *
     * @param args
     */
    public static void main(String[] args) {
        FirstChallenge firstChallenge = new FirstChallenge();
        try {
            double result1 = firstChallenge.divide(3, 0);
            System.out.println(result1);
        } catch (ArithmeticException e) {
            System.out.println("You can't divide by 0: " + e);
        } finally {
            System.out.println("End of math operation\n");
        }

        try {
            int result2 = firstChallenge.power(2, -3);
            System.out.println(result2);
        } catch (IllegalArgumentException e) {
            System.out.println("The base and exponent must be integer type 0 or higher : " + e);
        } finally {
            System.out.println("End of math operation\n");
        }
    }
}