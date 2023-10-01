package com.kodilla.spring;

import java.util.Arrays;

public class BubbleSort {

    public static void bubbleSort(int array[], int n) {
        int i, j, temp;
        boolean swapped;

        for (i = 0; i < n + 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (array[i] > array[i + j + 1]) {

                    temp = array[i + j + 1];
                    array[i + j + 1] = array[i];
                    array[i] = temp;
                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }
    }

    public static void main(String[] args) {

        int[] array = {2, 1, 8, 5, 4, 2, 4, 1};
        bubbleSort(array, array.length);
        System.out.println(Arrays.toString(array));

    }
}
