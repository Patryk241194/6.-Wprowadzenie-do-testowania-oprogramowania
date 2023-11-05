package com.kodilla.spring.converter;


public class DecimalToBinaryConverter {

    public static String convertDecimalToBinary(int decimalNumber) {
        if (decimalNumber == 0) {
            return "0";
        }

        StringBuilder binaryNumber = new StringBuilder();
        while (decimalNumber > 0) {
            int nextNumber = decimalNumber % 2;
            binaryNumber.append(nextNumber);
            decimalNumber /= 2;
        }

        return binaryNumber.reverse().toString();
    }
}
