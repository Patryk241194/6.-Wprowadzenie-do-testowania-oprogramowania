package com.kodilla.spring.converter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MorseCodeConverterTest {

    @Test
    void testTranslateMorseCodeExample1() {
        // Given
        MorseCodeConverter converter = new MorseCodeConverter();
        String morseCodeInput = ".- -.. .- --";

        // When
        String actualResult = converter.translateMorseCode(morseCodeInput);
        String expectedResult = "ADAM";

        // Then
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testTranslateMorseCodeExample2() {
        // Given
        MorseCodeConverter converter = new MorseCodeConverter();
        String morseCodeInput = "-.- --- -.. .. .-.. .-.. .-";

        // When
        String actualResult = converter.translateMorseCode(morseCodeInput);
        String expectedResult = "KODILLA";

        // Then
        assertEquals(expectedResult, actualResult);
    }
}