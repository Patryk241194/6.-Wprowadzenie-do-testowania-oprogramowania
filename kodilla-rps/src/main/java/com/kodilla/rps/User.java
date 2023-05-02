package com.kodilla.rps;

import java.util.Scanner;

public class User {

    private String username;
    private int numberOfRounds;
    private int numberOfRoundsWon;

    public User(Scanner scanner) {
        String name;
        int roundsToWin;

        do {
            System.out.println("Please enter your name:");
            name = scanner.nextLine().trim(); // remove whitespace from start and end

//          if-condition (name.isEmpty() || name.matches("\\s+") checks if the string is empty or consists only of whitespace.

            if (name.isEmpty() || name.matches("\\s+")) {
                System.out.println("Invalid input. Please enter a name with at least one digit.");
            }
        } while (name.isEmpty() || name.matches("\\s+"));

        do {
            System.out.println("Please enter the number of rounds to win:");
            roundsToWin = scanner.nextInt();
            if (roundsToWin <= 0) {
                System.out.println("Invalid input. Please enter a value higher than 0.");
            }
        } while (roundsToWin <= 0);

        this.username = name;
        this.numberOfRounds = roundsToWin;
        this.numberOfRoundsWon = 0;
    }

    public String getUsername() {
        return username;
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public int getNumberOfRoundsWon() {
        return numberOfRoundsWon;
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
