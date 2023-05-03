package com.kodilla.rps;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NPC {

    private String name;
    private String difficultyLevel;
    private int numberOfRounds;
    private int numberOfRoundsWon;

    public NPC(Scanner scanner) {
        this.name = "NPC";
        this.numberOfRoundsWon = 0;
        this.numberOfRounds = checkTheNumberOfRounds(scanner);
        checkDifficultyLevel(scanner);
    }

    private void checkDifficultyLevel(Scanner scanner) {
        do {
            System.out.print("Select the difficulty level: Normal \"N\" / Hard \"H\": ");
            this.difficultyLevel = scanner.next();
            if (!this.difficultyLevel.equals("N") && !this.difficultyLevel.equals("H")) {
                System.out.println("Invalid input. Please try again!");
            }
        } while (!this.difficultyLevel.equals("N") && !this.difficultyLevel.equals("H"));
    }

    private int checkTheNumberOfRounds(Scanner scanner) {
        boolean isCorrectType;
        int roundsToWin = 0;
        do {
            System.out.print("Please enter the number of rounds to win: ");

            try {
                roundsToWin = scanner.nextInt();
                isCorrectType = true;

                if (roundsToWin <= 0) {
                    System.out.println("Invalid input. Please enter a value higher than 0.");
                    isCorrectType = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a numerical integer value.");
                isCorrectType = false;
                scanner.next();
            }
        } while (!isCorrectType);

        return roundsToWin;
    }

    public String getName() {
        return name;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public int getNumberOfRoundsWon() {
        return numberOfRoundsWon;
    }

    public void setNumberOfRoundsWon(int numberOfRoundsWon) {
        this.numberOfRoundsWon = numberOfRoundsWon;
    }

    @Override
    public String toString() {
        return "NPC{" +
                "name='" + name + '\'' +
                ", difficultyLevel='" + difficultyLevel + '\'' +
                ", numberOfRounds=" + numberOfRounds +
                ", numberOfRoundsWon=" + numberOfRoundsWon +
                '}';
    }
}
