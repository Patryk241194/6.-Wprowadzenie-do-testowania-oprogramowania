package com.kodilla.patterns.enums.hotel;

import static com.kodilla.patterns.enums.hotel.Season.HIGH;
import static com.kodilla.patterns.enums.hotel.Season.HOLIDAY;
import static com.kodilla.patterns.enums.hotel.Season.LOW;

public class HotelApp {
    public static void main(String[] args) {
        System.out.println("Accommodation prices:");
        System.out.println("1. Single Bed rooms");
        System.out.println("   - low season: " + LOW.getSingleRoomPrice());
        System.out.println("   - high season: " + HIGH.getSingleRoomPrice());
        System.out.println("   - holiday season: " + HOLIDAY.getSingleRoomPrice());
        System.out.println("2. Double Bed rooms");
        System.out.println("   - low season: " + LOW.getDoubleRoomPrice());
        System.out.println("   - high season: " + HIGH.getDoubleRoomPrice());
        System.out.println("   - holiday season: " + HOLIDAY.getDoubleRoomPrice());
    }
}
