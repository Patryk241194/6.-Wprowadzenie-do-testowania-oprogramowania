package com.kodilla.patterns.enums.hotel;

import java.math.BigDecimal;
import java.util.Map;

import static com.kodilla.patterns.enums.hotel.Season.HIGH;
import static com.kodilla.patterns.enums.hotel.Season.HOLIDAY;
import static com.kodilla.patterns.enums.hotel.Season.LOW;

public class PriceList {

    private static Map<Season, BigDecimal> singleBedPrices = Map.of(
            LOW, new BigDecimal(250),
            HIGH, new BigDecimal(320),
            HOLIDAY, new BigDecimal(400)
    );

    private static Map<Season, BigDecimal> doubleBedPrices = Map.of(
            LOW, new BigDecimal(350),
            HIGH, new BigDecimal(400),
            HOLIDAY, new BigDecimal(500)
    );

    public static BigDecimal getSingleBedPrice(Season season) {
        return singleBedPrices.get(season);
    }

    public static BigDecimal getDoubleBedPrice(Season season) {
        return doubleBedPrices.get(season);
    }
}
