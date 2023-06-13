package com.kodilla.good.patterns.food2door.customer;

public class User {
    private String username;
    private String name;
    private String surname;
    private Integer phoneNumber;
    private String email;
    private boolean isMembershipActive;

    public User(String username, String name, String surname, Integer phoneNumber, String email, boolean isMembershipActive) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.isMembershipActive = isMembershipActive;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public boolean isMembershipActive() {
        return isMembershipActive;
    }
}
