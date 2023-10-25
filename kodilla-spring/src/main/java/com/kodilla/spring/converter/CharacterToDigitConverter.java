package com.kodilla.spring.converter;

public class CharacterToDigitConverter {

    public static int convertCharacterToDigit(char c) {
        if (c >= '0' && c <= '9') {
            return Character.getNumericValue(c);
        } else {
            throw new IllegalArgumentException("Error: Invalid character. Please provide a character from '0' to '9'.");
        }
    }

    public static void main(String[] args) {
        char inputChar = '7';
        try {
            int result = convertCharacterToDigit(inputChar);
            System.out.println("Result: " + result);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: Invalid character. Please provide a character from '0' to '9'.");
        }
    }
}
