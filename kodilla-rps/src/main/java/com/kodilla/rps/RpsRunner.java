package com.kodilla.rps;

import java.util.Scanner;

public class RpsRunner {
    public static void main(String[] args) {
        Game game = new RockPaperScissors(new Scanner(System.in));
        game.play();
    }
}
