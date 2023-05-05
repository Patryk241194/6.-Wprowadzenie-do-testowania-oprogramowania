package com.kodilla.exception.test;

public class ExceptionHandling {
    public static void main(String[] args) {

        SecondChallenge challenge = new SecondChallenge();
        try {
            String result = challenge.probablyIWillThrowException(1,0);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Wrong value entered for variable x or y!");
        } finally {
            System.out.println("The second challenge has started!");
        }
    }
}
