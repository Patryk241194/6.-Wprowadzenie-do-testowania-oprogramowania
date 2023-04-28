package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorldTestSuite {

    @Test
    void testGetPeopleQuantity() {
        //Given
        Country china = new Country("China", new BigDecimal("1400000000"));
        Country india = new Country("India", new BigDecimal("1300000000"));
        Country nigeria = new Country("Nigeria", new BigDecimal("206000000"));
        Country ethiopia = new Country("Ethiopia", new BigDecimal("117000000"));
        Country US = new Country("United States", new BigDecimal("331000000"));
        Country mexico = new Country("Mexico", new BigDecimal("129000000"));
        Country brazil = new Country("Brazil", new BigDecimal("213000000"));
        Country colombia = new Country("Colombia", new BigDecimal("50000000"));
        Country UK = new Country("United Kingdom", new BigDecimal("68000000"));
        Country germany = new Country("Germany", new BigDecimal("83000000"));

        Continent asia = new Continent("Asia");
        asia.addCountry(china);
        asia.addCountry(india);

        Continent africa = new Continent("Africa");
        africa.addCountry(nigeria);
        africa.addCountry(ethiopia);

        Continent northAmerica = new Continent("North America");
        northAmerica.addCountry(US);
        northAmerica.addCountry(mexico);

        Continent southAmerica = new Continent("South America");
        southAmerica.addCountry(brazil);
        southAmerica.addCountry(colombia);

        Continent europe = new Continent("Europe");
        europe.addCountry(UK);
        europe.addCountry(germany);

        World world = new World();
        world.addContinent(asia);
        world.addContinent(africa);
        world.addContinent(northAmerica);
        world.addContinent(southAmerica);
        world.addContinent(europe);

        //When
        BigDecimal result = world.getPeopleQuantity();

        //Then
        BigDecimal expectedResult = new BigDecimal("3897000000");
        assertEquals(expectedResult, result);
    }
}
