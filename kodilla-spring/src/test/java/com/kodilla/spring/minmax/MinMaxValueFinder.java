package com.kodilla.spring.minmax;

public class MinMaxValueFinder {

    public static int findMaximumValue(int[] arrayOfNumbers) {
        if (arrayOfNumbers.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }

        int maxValue = arrayOfNumbers[0];
        for (int i = 1; i < arrayOfNumbers.length; i++) {
            if (arrayOfNumbers[i] > maxValue) {
                maxValue = arrayOfNumbers[i];
            }
        }
        return maxValue;
    }

    public static int findMinimumValue(int[] arrayOfNumbers) {
        if (arrayOfNumbers.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }

        int minValue = arrayOfNumbers[0];
        for (int i = 1; i < arrayOfNumbers.length; i++) {
            if (arrayOfNumbers[i] < minValue) {
                minValue = arrayOfNumbers[i];
            }
        }
        return minValue;
    }


}


