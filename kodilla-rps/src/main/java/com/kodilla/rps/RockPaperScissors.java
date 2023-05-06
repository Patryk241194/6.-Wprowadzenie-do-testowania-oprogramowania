package com.kodilla.rps;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RockPaperScissors implements Game {

    private User user;
    private NPC npc;
    private GameValidator validator;
    private ConsoleInputReader inputReader;
    private String userChoice;
    private String npcChoice;

    public RockPaperScissors() {
        validator = new GameValidator();
        inputReader = new ConsoleInputReader();
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setNpc(NPC npc) {
        this.npc = npc;
    }

    public void setUserChoice(String userChoice) {
        this.userChoice = userChoice;
    }

    public void setNpcChoice(String npcChoice) {
        this.npcChoice = npcChoice;
    }

    public void play() {
        user = new User(inputReader.getScannerInputForUsername());
        boolean endOfGame = false;
        while (!endOfGame) {

            try {
                npc = new NPC(validator.checkDifficultyLevel(inputReader.getScannerInputForDifficulty()),
                        validator.checkTheNumberOfRounds(inputReader.getScannerInputForNumberOfRounds()));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            this.displayStartScreen();
            this.showRules();
            int roundCounter = 0;
            boolean endOfMatch = false;
            while (!endOfMatch) {

                roundCounter++;
                System.out.print("\nUser " + user.getUsername() + ", please make a move: ");

                // 1) user choice
                userChoice = choiceOfUser(inputReader.getScannerInputForCheckUserChoice());

                // 2) npc choice
                npcChoice = choiceOfNPC(generatorOfChoice());

                // 3) The game begins
                System.out.println("\nRound #" + roundCounter);
                System.out.println("User " + user.getUsername() + " plays " + userChoice);
                System.out.println("NPC plays " + npcChoice);

                this.runGameMechanics();
                endOfMatch = showResult();
                if (endOfMatch) {
                    endOfGame = isEndOfGame(inputReader.getScannerInputForCheckWannaPlayAgain());
                }
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
        System.out.println("Current game score:\n" +
                user.getUsername() + " " + user.getNumberOfRoundsWon() + " : " +
                "NPC(" + (npc.getDifficultyLevel().equals("N") ? "normal" : "hard") + ") " +
                npc.getNumberOfRoundsWon());
    }

    protected String choiceOfNPC(String computerMove) {
        return computerMove;
    }

    protected String generatorOfChoice() {
        // Hard Level: The odds of a draw and a NPC loss are 25% each, and the odds of NPC winning are 50%.
        String computer = null;

        Random random = new Random();
        String[] variants = {"Rock", "Paper", "Scissors"};
        if (npc.getDifficultyLevel().equals("N")) {
            computer = variants[random.nextInt(variants.length)];
        } else if (npc.getDifficultyLevel().equals("H")) {
            Map<String, String[]> choicesMap = new HashMap<>();
            choicesMap.put("Rock", new String[]{"Rock", "Paper", "Paper", "Scissors"});
            choicesMap.put("Paper", new String[]{"Rock", "Paper", "Scissors", "Scissors"});
            choicesMap.put("Scissors", new String[]{"Rock", "Rock", "Paper", "Scissors"});
            computer = choicesMap.get(userChoice)[random.nextInt(4)];
        }
        return computer;
    }

    protected String choiceOfUser(int userInput) {
        return validator.checkUserChoice(userInput);
    }

    protected boolean showResult() {

        boolean isGameDone = false;
        if (user.getNumberOfRoundsWon() >= npc.getNumberOfRounds()) {
            isGameDone = true;
            System.out.println("Game over! The game was won by the player " + user.getUsername() + " with the result:\n"
                    + user.getUsername() + ": " + user.getNumberOfRoundsWon() + " duels won.\n"
                    + "NPC: " + npc.getNumberOfRoundsWon() + " duels won.");
        }

        if (npc.getNumberOfRoundsWon() >= npc.getNumberOfRounds()) {
            isGameDone = true;
            System.out.println("Game over! The game was won by NPC with the result:\n"
                    + "NPC: " + npc.getNumberOfRoundsWon() + " duels won.\n"
                    + user.getUsername() + ": " + user.getNumberOfRoundsWon() + " duels won.");
        }
        return isGameDone;
    }

    protected boolean isEndOfGame(String isGameContinued) {
        boolean gameOver = false;
        String wannaPlayAgain = null;

        user.setNumberOfRoundsWon(0);
        npc.setNumberOfRoundsWon(0);

        wannaPlayAgain = validator.checkWannaPlayAgain(isGameContinued);

        if (wannaPlayAgain.equals("n")) {
            System.out.println("\nNew game begins!\n");
        }
        if (wannaPlayAgain.equals("x")) {
            System.out.println("\nThe End!\n");
            gameOver = true;
        }
        return gameOver;
    }
}


