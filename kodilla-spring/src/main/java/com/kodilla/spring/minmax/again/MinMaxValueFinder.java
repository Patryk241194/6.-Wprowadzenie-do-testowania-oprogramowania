package com.kodilla.spring.minmax.again;

import java.util.ArrayList;
import java.util.List;

public class MinMaxValueFinder {

    public static int findMinValue(int[] arrayOfNumbers) {
        if (arrayOfNumbers.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }

        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < arrayOfNumbers.length; i++) {
            if (arrayOfNumbers[i] >= 0 && arrayOfNumbers[i] < minValue) {
                minValue = arrayOfNumbers[i];
            }
        }
        return minValue;
    }


    public static List<Integer> segregateArrayOfNumbers(int[] arrayOfNumbers) {
        List<Integer> sortedList = new ArrayList<>();

        while (sortedList.size() < arrayOfNumbers.length) {
            int currentMinValue = findMinValue(arrayOfNumbers);

            for (int i = 0; i < arrayOfNumbers.length; i++) {
                if (arrayOfNumbers[i] == currentMinValue) {
                    sortedList.add(currentMinValue);
                    arrayOfNumbers[i] = -arrayOfNumbers[i];
                    break;
                }
            }
        }
        return sortedList;
    }

    public static void main(String[] args) {


        int[] randomArray1 = {4, 5, 2, 1, 5};
        int[] randomArray2 = {4, 5, 2, 6, 5};
        System.out.println(findMinValue(randomArray1));
        System.out.println(findMinValue(randomArray2));

        System.out.println(segregateArrayOfNumbers(randomArray1));





    }

}
