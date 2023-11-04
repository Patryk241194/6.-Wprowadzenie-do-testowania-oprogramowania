package com.kodilla.spring.converter;

public class StringToNumberConverter {

    public static int convertStringToNumber(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Error: Invalid input, please provide a valid integer string.");
        }
    }

    public static void main(String[] args) {
        String stringInput = "2040";
        System.out.println(convertStringToNumber(stringInput));
    }


}
