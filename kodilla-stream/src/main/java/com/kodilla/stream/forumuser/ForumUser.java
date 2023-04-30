package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.time.Period;

public class ForumUser {
    private int id;
    private String username;
    private char gender;
    private LocalDate dateOfBirth;
    private int numberOfPosts;

    public ForumUser(int id, String username, char gender, LocalDate dateOfBirth, int numberOfPosts) {
        this.id = id;
        this.username = username;
        this.dateOfBirth = dateOfBirth;
        this.numberOfPosts = numberOfPosts;
        if (gender == 'M' || gender == 'F' || gender == 'm' || gender == 'f') {
            this.gender = gender;
        } else {
            throw new IllegalArgumentException("Unknown gender symbol: \'" + gender + "\'");
        }
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public char getGender() {
        return gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Period getUserAge() {
        LocalDate today = LocalDate.now();
        return Period.between(dateOfBirth, today);
    }

    public int getNumberOfPosts() {
        return numberOfPosts;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "id=" + String.format("%05d", id) +
                ", username='" + username + '\'' +
                ", gender=" + Character.toUpperCase(gender) +
                ", dateOfBirth=" + dateOfBirth +
                ", numberOfPosts=" + numberOfPosts +
                '}';
    }
}
