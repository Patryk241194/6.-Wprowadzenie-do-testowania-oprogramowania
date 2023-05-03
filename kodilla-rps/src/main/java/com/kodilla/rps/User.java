package com.kodilla.rps;

import java.util.InputMismatchException;
import java.util.Scanner;

public class User {

    private final String username;
    private int numberOfRounds;
    private int numberOfRoundsWon;

    public User(Scanner scanner) {
        this.username = checkTheName(scanner);
        this.numberOfRoundsWon = 0;
    }

    private String checkTheName(Scanner scanner) {
        String name;
        do {
            System.out.print("Please enter your name: ");
            name = scanner.nextLine().trim(); // remove whitespace from start and end

//          if-condition (name.isEmpty() || name.matches("\\s+") checks if the string is empty or consists only of whitespace.

            if (name.isEmpty() || name.matches("\\s+")) {
                System.out.println("Invalid input. Please enter a name with at least one digit.");
            }
        } while (name.isEmpty() || name.matches("\\s+"));

        return name;
    }

    public String getUsername() {
        return username;
    }

    public int getNumberOfRoundsWon() {
        return numberOfRoundsWon;
    }

    public void setNumberOfRoundsWon(int numberOfRoundsWon) {
        this.numberOfRoundsWon = numberOfRoundsWon;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", numberOfRounds=" + numberOfRounds +
                ", numberOfRoundsWon=" + numberOfRoundsWon +
                '}';
    }
}
