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

    public static int findSecondMaximumValue(int[] arrayOfNumbers) {
        if (arrayOfNumbers.length < 2) {
            throw new IllegalArgumentException("Array has less than 2 numbers");
        }

        int maxValue1 = arrayOfNumbers[0];
        int maxValue2 = arrayOfNumbers[1];

        if (maxValue2 > maxValue1) {
            int tempValue = maxValue1;
            maxValue1 = maxValue2;
            maxValue2 = tempValue;
        }

        for (int i = 2; i < arrayOfNumbers.length; i++) {
            if (arrayOfNumbers[i] > maxValue1) {
                maxValue2 = maxValue1;
                maxValue1 = arrayOfNumbers[i];
            } else if (arrayOfNumbers[i] > maxValue2 && arrayOfNumbers[i] != maxValue1) {
                maxValue2 = arrayOfNumbers[i];
            }
        }

        return maxValue2;
    }

    public static int findMinimumValue(int[] arrayOfNumbers) {
        if (arrayOfNumbers.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }

        int minValue = arrayOfNumbers[0];
        for (int i = 1; i < arrayOfNumbers.length; i++) {
            if (arrayOfNumbers[i] >= 0 && arrayOfNumbers[i] < minValue) {
                minValue = arrayOfNumbers[i];
            }
        }
        return minValue;
    }

    public static int findSecondMinimumValue(int[] arrayOfNumbers) {
        if (arrayOfNumbers.length < 2) {
            throw new IllegalArgumentException("Array has less than 2 numbers");
        }

        int minValue1 = arrayOfNumbers[0];
        int minValue2 = arrayOfNumbers[1];

        if (minValue2 < minValue1) {
            int tempValue = minValue1;
            minValue1 = minValue2;
            minValue2 = tempValue;
        }

        for (int i = 2; i < arrayOfNumbers.length; i++) {
            if (arrayOfNumbers[i] < minValue1) {
                minValue2 = minValue1;
                minValue1 = arrayOfNumbers[i];
            } else if (arrayOfNumbers[i] < minValue2 && arrayOfNumbers[i] != minValue1) {
                minValue2 = arrayOfNumbers[i];
            }
        }

        return minValue2;
    }
}


