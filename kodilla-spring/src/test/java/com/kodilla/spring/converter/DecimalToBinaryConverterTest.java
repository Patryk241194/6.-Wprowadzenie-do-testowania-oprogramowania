package com.kodilla.spring.converter;

import org.junit.jupiter.api.Test;

import static com.kodilla.spring.converter.DecimalToBinaryConverter.convertDecimalToBinary;
import static org.junit.jupiter.api.Assertions.*;

class DecimalToBinaryConverterTest {

    @Test
    void shouldConvertDecimalToBinary() {
        //Given
        int decimalNumber = 173;

        //When
        String expectedBinaryNumber = Integer.toBinaryString(decimalNumber);
        String actualBinaryNumber = convertDecimalToBinary(decimalNumber);

        //Then
        assertEquals(expectedBinaryNumber, actualBinaryNumber);
    }

}