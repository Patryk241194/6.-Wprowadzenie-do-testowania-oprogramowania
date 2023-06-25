package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BigmacTestSuite {

    @Test
    void testBigmacOne() {
        // Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .ingredient("chili peppers")
                .ingredient("bacon")
                .burgers(2)
                .bun("with sesame")
                .sauce("barbecue")
                .ingredient("cheese")
                .build();
        System.out.println(bigmac);

        // When & Then
        assertEquals(3, bigmac.getIngredients().size());
        assertEquals(2, bigmac.getBurgers());
        assertEquals("barbecue", bigmac.getSauce());
        assertEquals("with sesame", bigmac.getBun());
    }

    @Test
    void testBigmacTwo() {
        // Given
        Bigmac.BigmacBuilder builder = new Bigmac.BigmacBuilder()
                .bun("invalid bun")
                .burgers(2)
                .sauce("barbecue")
                .ingredient("lettuce")
                .ingredient("invalid ingredient");

        // When & Then
        assertThrows(IllegalArgumentException.class, () -> builder.build());
    }
}
