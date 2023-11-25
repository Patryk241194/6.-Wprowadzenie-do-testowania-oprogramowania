package com.kodilla.spring.converter;

public class DecimalToHexadecimalConverter {

    public static String convertDecimalToHexadecimal(int decimalNumber) {
        if (decimalNumber == 0) {
            return "0";
        }

        StringBuilder hexadecimalNumber = new StringBuilder();
        while (decimalNumber > 0) {
            int nextNumber = decimalNumber % 16;
            String hexDigit;
            switch (nextNumber) {
                case 10:
                    hexDigit = "a";
                    break;
                case 11:
                    hexDigit = "b";
                    break;
                case 12:
                    hexDigit = "c";
                    break;
                case 13:
                    hexDigit = "d";
                    break;
                case 14:
                    hexDigit = "e";
                    break;
                case 15:
                    hexDigit = "f";
                    break;
                default:
                    hexDigit = Integer.toString(nextNumber);
                    break;
            }
            hexadecimalNumber.append(hexDigit);
            decimalNumber /= 16;
        }
        return hexadecimalNumber.reverse().toString();
    }

}
