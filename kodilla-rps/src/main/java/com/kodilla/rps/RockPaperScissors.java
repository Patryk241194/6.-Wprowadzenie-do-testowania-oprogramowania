package com.kodilla.rps;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors implements Game {

    private User user;
    private NPC npc;
    private Scanner scanner;

    public RockPaperScissors(Scanner scanner) {
        this.scanner = scanner;
        user = new User(scanner);
        npc = new NPC(scanner);
    }

    public void play() {
        this.displayStartScreen();
        this.showRules();
    }

    public void displayStartScreen() {
        System.out.println("Welcome " + user.getUsername() + ". You need to win " +
                user.getNumberOfRounds() + " rounds to win the game.");
    }

    public void showRules() {
        System.out.println("Key 1 - Play \"Rock\",");
        System.out.println("Key 2 - Play \"Paper\",");
        System.out.println("Key 3 - Play \"Scissors\",");
        System.out.println("Key x - End game,");
        System.out.println("Key n - Restart game.");
    }

    public void beginTheGame() {
        boolean end = false;
        while (!end) {
            String[] variants = {"Rock", "Paper", "Scissor"};
            Random random = new Random();

            String userChoice = variants[scanner.nextInt()];
            String npcChoice = variants[random.nextInt(variants.length)];

            if (user.getNumberOfRoundsWon() == user.getNumberOfRounds()) {
                end = true;
            }
        }
    }

}

