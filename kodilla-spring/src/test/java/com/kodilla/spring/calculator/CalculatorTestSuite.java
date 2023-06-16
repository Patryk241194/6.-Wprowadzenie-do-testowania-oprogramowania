package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class CalculatorTestSuite {
    @Autowired
    private Calculator calculator;

    @Test
    void testCalculations() {
        // when
        double a = 3;
        double b = 1;
        // given
        double result1 = calculator.add(a, b);
        double result2 = calculator.sub(a, b);
        double result3 = calculator.mul(a, b);
        double result4 = calculator.div(a, b);
        // then
        assertEquals(4, result1);
        assertEquals(2, result2);
        assertEquals(3, result3);
        assertEquals(3, result4);
    }
}
