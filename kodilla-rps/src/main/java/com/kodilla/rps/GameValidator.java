package com.kodilla.rps;

import java.util.InputMismatchException;

public class GameValidator {

    public String checkDifficultyLevel(String difficulty) throws Exception {
        String difficultyLevel = null;

        if (!difficulty.equals("N") && !difficulty.equals("H")) {
            throw new RuntimeException("Invalid Input");
        } else {
            difficultyLevel = difficulty;
        }
        return difficultyLevel;
    }

    public int checkTheNumberOfRounds(int amountOfRounds) {
        int roundsToWin = 0;
        if (amountOfRounds <= 0) {
            throw new InputMismatchException("Invalid Input");
        } else {
            roundsToWin = amountOfRounds;
        }
        return roundsToWin;
    }

    public String checkUserChoice(int userInput) {
        String[] variants = {"Rock", "Paper", "Scissors"};
        String choice = null;

        if (userInput == 1 || userInput == 2 || userInput == 3) {
            choice = variants[userInput - 1];
        } else {
            throw new IllegalArgumentException("Invalid user input, please try again.");
        }
        return choice;
    }

    public String checkWannaPlayAgain(String isGameContinued) {
        String wannaPlayAgain = null;

        if (!isGameContinued.equals("n") && !isGameContinued.equals("x")) {
            throw new IllegalArgumentException("Invalid input, please enter 'n' or 'x'");
        } else {
            wannaPlayAgain = isGameContinued;
        }
        return wannaPlayAgain;
    }
}
