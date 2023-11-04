package com.kodilla.patterns2.decorator.pizza;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BasicPizzaOrderTest {

    @Test
    public void testLargePizzaWithExtraCheese() {
        // Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new LargeSizeDecorator(theOrder);
        theOrder = new ExtraCheeseDecorator(theOrder);

        // When
        BigDecimal cost = theOrder.getCost();
        String description = theOrder.getDescription();

        // Then
        assertEquals(new BigDecimal(26), cost);
        assertEquals("Pizza with tomato sauce and cheese (large size) with extra cheese", description);
    }

    @Test
    public void testPizzaWithHamAndMushrooms() {
        // Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new HamDecorator(theOrder);
        theOrder = new MushroomsDecorator(theOrder);

        // When
        BigDecimal cost = theOrder.getCost();
        String description = theOrder.getDescription();

        // Then
        assertEquals(new BigDecimal(21), cost);
        assertEquals("Pizza with tomato sauce and cheese with ham with mushrooms", description);
    }
}