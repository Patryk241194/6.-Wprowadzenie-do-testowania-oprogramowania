package com.kodilla.rps;

public class NPC {

    private String name;
    private String difficultyLevel;
    private int numberOfRounds;
    private int numberOfRoundsWon;

    public NPC(String difficultyLevel, int numberOfRounds) {
        this.name = "NPC";
        this.numberOfRoundsWon = 0;
        this.difficultyLevel = difficultyLevel;
        this.numberOfRounds = numberOfRounds;
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
