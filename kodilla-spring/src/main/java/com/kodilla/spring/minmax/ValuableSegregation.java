package com.kodilla.spring.minmax;

import java.util.ArrayList;
import java.util.List;

import static com.kodilla.spring.minmax.MinMaxValueFinder.findMinimumValue;

public class ValuableSegregation {

    public static List<Integer> sortArrayOfNumbers(int[] arrayOfNumbers) {
        List<Integer> sortedList = new ArrayList<>();

        while (sortedList.size() < arrayOfNumbers.length) {
            int minValue = findMinimumValue(arrayOfNumbers);

            for (int i = 0; i < arrayOfNumbers.length; i++) {
                if (arrayOfNumbers[i] == minValue) {
                    arrayOfNumbers[i] = -arrayOfNumbers[i];
                    break;
                }
            }

            sortedList.add(minValue);
        }

        return sortedList;
    }
}
