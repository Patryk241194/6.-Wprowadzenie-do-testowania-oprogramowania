package com.kodilla.rps;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors implements Game {

    private User user;
    private NPC npc;
    private Scanner scanner;
    private String userChoice;
    private String npcChoice;

    public RockPaperScissors(Scanner scanner) {
        this.scanner = scanner;
    }

    public void play() {
        user = new User(scanner);
        boolean endOfGame = false;
        while (!endOfGame) {

            npc = new NPC(scanner);
            this.displayStartScreen();
            this.showRules();
            int roundCounter = 0;
            boolean endOfMatch = false;
            while (!endOfMatch) {

                String[] variants = {"Rock", "Paper", "Scissors"};
                roundCounter++;
                System.out.print("\nUser " + user.getUsername() + ", please make a move: ");

                // 1) user choice
                checkUserChoiceForExceptions(variants);

                // 2) npc choice
                choiceOfNPC(variants);

                // 3) The game begins
                System.out.println("\nRound #" + roundCounter);
                System.out.println("User " + user.getUsername() + " plays " + userChoice);
                System.out.println("NPC plays " + npcChoice);

                this.runGameMechanics();
                endOfMatch = showResult(endOfMatch);
                endOfGame = isEndOfGame(endOfGame, endOfMatch);
            }
        }
    }

    public void displayStartScreen() {
        System.out.println("\nWelcome " + user.getUsername() + ". You need to win " +
                npc.getNumberOfRounds() + " rounds to win the game.");
    }

    public void showRules() {
        System.out.println("Key 1 - Play \"Rock\",");
        System.out.println("Key 2 - Play \"Paper\",");
        System.out.println("Key 3 - Play \"Scissors\",");
    }

    public void runGameMechanics() {
        if (userChoice.equals(npcChoice)) {
            System.out.println("Draw!");
        } else if (userChoice.equals("Rock") && npcChoice.equals("Scissors") ||
                userChoice.equals("Paper") && npcChoice.equals("Rock") ||
                userChoice.equals("Scissors") && npcChoice.equals("Paper")) {
            System.out.println("You won this round!");
            user.setNumberOfRoundsWon(user.getNumberOfRoundsWon() + 1);
        } else {
            System.out.println("NPC won this round.");
            npc.setNumberOfRoundsWon(npc.getNumberOfRoundsWon() + 1);
        }
        if (npc.getDifficultyLevel().equals("N")) {
            System.out.println("Current game score:\n"
                    + user.getUsername() + " " + user.getNumberOfRoundsWon() + "  :  "
                    + "NPC(normal) " + npc.getNumberOfRoundsWon());
        } else if (npc.getDifficultyLevel().equals("H")) {
            System.out.println("Current game score:\n"
                    + user.getUsername() + " " + user.getNumberOfRoundsWon() + "  :  "
                    + "NPC(hard) " + npc.getNumberOfRoundsWon());
        }
    }

    private void choiceOfNPC(String[] variants) {
        // Hard Level: The odds of a draw and a NPC loss are 25% each, and the odds of NPC winning are 50%.

        Random random = new Random();
        if (npc.getDifficultyLevel().equals("N")) {
            npcChoice = variants[random.nextInt(variants.length)];
        } else if (npc.getDifficultyLevel().equals("H")) {
            if (userChoice.equals("Rock")) {
                String[] variants1 = {"Rock", "Paper", "Paper", "Scissors"};
                npcChoice = variants1[random.nextInt(variants1.length)];
            }
            if (userChoice.equals("Paper")) {
                String[] variants2 = {"Rock", "Paper", "Scissors", "Scissors"};
                npcChoice = variants2[random.nextInt(variants2.length)];
            }
            if (userChoice.equals("Scissors")) {
                String[] variants3 = {"Rock", "Rock", "Paper", "Scissors"};
                npcChoice = variants3[random.nextInt(variants3.length)];
            }
        }
    }

    private void checkUserChoiceForExceptions(String[] variants) {
        int userInput;
        boolean isCorrectType;
        do {
            try {
                userInput = scanner.nextInt();
                isCorrectType = true;

                if (userInput == 1 || userInput == 2 || userInput == 3) {
                    userChoice = variants[userInput - 1];
                } else {
                    System.out.print("Invalid user input, please try again: ");
                    isCorrectType = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a numerical integer value: ");
                isCorrectType = false;
                scanner.next();
            }
        } while (!isCorrectType);
    }

    private boolean showResult(boolean endOfMatch) {
        if (user.getNumberOfRoundsWon() == npc.getNumberOfRounds()) {
            endOfMatch = true;
            System.out.println("Game over! The game was won by the player " + user.getUsername() + " with the result:\n"
                    + user.getUsername() + ": " + user.getNumberOfRoundsWon() + " duels won.\n"
                    + "NPC: " + npc.getNumberOfRoundsWon() + " duels won.");
        }

        if (npc.getNumberOfRoundsWon() == npc.getNumberOfRounds()) {
            endOfMatch = true;
            System.out.println("Game over! The game was won by NPC with the result:\n"
                    + "NPC: " + npc.getNumberOfRoundsWon() + " duels won.\n"
                    + user.getUsername() + ": " + user.getNumberOfRoundsWon() + " duels won.");
        }
        return endOfMatch;
    }

    private boolean isEndOfGame(boolean endOfGame, boolean endOfMatch) {
        if (endOfMatch) {
            user.setNumberOfRoundsWon(0);
            npc.setNumberOfRoundsWon(0);
            System.out.println("\nChoose whether you want to continue playing or quit the game.");
            System.out.println("Key x - End game,");
            System.out.println("Key n - Restart game.");

            boolean validInput = false;
            do {
                String wannaPlayAgain = scanner.next();
                try {
                    if (!wannaPlayAgain.equals("n") && !wannaPlayAgain.equals("x")) {
                        throw new IllegalArgumentException("Invalid input, please enter 'n' or 'x'");
                    }
                    if (wannaPlayAgain.equals("n")) {
                        System.out.println("\nNew game begins!\n");
                        endOfGame = false;
                        validInput = true;
                    }
                    if (wannaPlayAgain.equals("x")) {
                        System.out.println("\nThe End!\n");
                        endOfGame = true;
                        validInput = true;
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } while (!validInput);
        }
        return endOfGame;
    }
}


