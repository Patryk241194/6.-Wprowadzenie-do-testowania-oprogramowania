package com.kodilla.rps;

public class User {

    private final String username;
    private int numberOfRoundsWon;

    public User(String username) {
        this.username = username;
        this.numberOfRoundsWon = 0;
    }

    public String getUsername() {
        return username;
    }

    public int getNumberOfRoundsWon() {
        return numberOfRoundsWon;
    }

    public void setNumberOfRoundsWon(int numberOfRoundsWon) {
        this.numberOfRoundsWon = numberOfRoundsWon;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", numberOfRoundsWon=" + numberOfRoundsWon +
                '}';
    }
}
