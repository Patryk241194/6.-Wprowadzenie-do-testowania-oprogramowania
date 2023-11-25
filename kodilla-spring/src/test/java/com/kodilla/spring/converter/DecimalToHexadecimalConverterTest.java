package com.kodilla.spring.converter;

import org.junit.jupiter.api.Test;

import static com.kodilla.spring.converter.DecimalToHexadecimalConverter.convertDecimalToHexadecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DecimalToHexadecimalConverterTest {

    @Test
    void shouldConvertDecimalToHexadecimal() {
        // Given
        int decimalNumber = 19537;

        // When
        String expectedHexadecimalNumber = Integer.toHexString(decimalNumber);
        String actualHexadecimalNumber = convertDecimalToHexadecimal(decimalNumber);

        // Then
        assertEquals(expectedHexadecimalNumber, actualHexadecimalNumber);
    }

}