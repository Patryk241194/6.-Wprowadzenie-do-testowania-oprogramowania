package com.kodilla.good.patterns.challenges;

public class User {
    private String username;
    private String name;
    private String surname;
    private Integer phoneNumber;
    private String email;

    public User(String username, String name, String surname, Integer phoneNumber, String email) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }
}
