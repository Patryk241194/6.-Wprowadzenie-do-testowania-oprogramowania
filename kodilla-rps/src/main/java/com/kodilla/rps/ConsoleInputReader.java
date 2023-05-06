package com.kodilla.rps;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleInputReader {
    private Scanner scanner;

    public ConsoleInputReader() {
        scanner = new Scanner(System.in);
    }

    public String getScannerInputForUsername() {
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

    public String getScannerInputForDifficulty() {
        String difficulty;
        do {
            System.out.print("Select the difficulty level: Normal \"N\" / Hard \"H\": ");
            difficulty = scanner.next();
            if (!difficulty.equals("N") && !difficulty.equals("H")) {
                System.out.println("Invalid input. Please try again!");
            }
        } while (!difficulty.equals("N") && !difficulty.equals("H"));

        return difficulty;
    }

    public int getScannerInputForNumberOfRounds() {
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

    public int getScannerInputForCheckUserChoice() {
        int userInput = 0;
        boolean isCorrectType;
        do {
            try {
                userInput = scanner.nextInt();
                if (userInput == 1 || userInput == 2 || userInput == 3) {
                    isCorrectType = true;
                } else {
                    System.out.print("Invalid user input, please try again: ");
                    isCorrectType = false;
                }
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. \nPlease enter a numerical integer value: ");
                isCorrectType = false;
                scanner.next();
            }
        } while (!isCorrectType);
        return userInput;
    }

    public String getScannerInputForCheckWannaPlayAgain() {
        System.out.println("\nChoose whether you want to continue playing or quit the game.");
        System.out.println("Key x - End game,");
        System.out.println("Key n - Restart game.");

        String wannaPlayAgain;
        boolean validInput = false;
        do {
            wannaPlayAgain = scanner.next();
            try {
                if (!wannaPlayAgain.equals("n") && !wannaPlayAgain.equals("x")) {
                    throw new IllegalArgumentException("Invalid input, please enter 'n' or 'x'");
                } else {
                    validInput = true;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!validInput);
        return wannaPlayAgain;
    }
}

