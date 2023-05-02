package com.kodilla.rps;

import java.util.Scanner;

public class NPC {

    private String name;
    private String difficultyLevel;
    private int numberOfRoundsWon;

    public NPC(Scanner scanner) {
        this.name = "NPC";
        this.numberOfRoundsWon = 0;

        do {
            System.out.println("Select the difficulty level: Normal \"N\" / Hard \"H\":");
            this.difficultyLevel = scanner.next();
            if (!this.difficultyLevel.equals("N") && !this.difficultyLevel.equals("H")) {
                System.out.println("Invalid input. Please enter the difficulty level: Normal \"N\" / Hard \"H\":");
            }
        } while (!this.difficultyLevel.equals("N") && !this.difficultyLevel.equals("H"));
    }

    public String getName() {
        return name;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public int getNumberOfRoundsWon() {
        return numberOfRoundsWon;
    }

    @Override
    public String toString() {
        return "NPC{" +
                "name='" + name + '\'' +
                ", difficultyLevel=" + difficultyLevel +
                ", numberOfRounds=" + numberOfRoundsWon +
                '}';
    }
}
