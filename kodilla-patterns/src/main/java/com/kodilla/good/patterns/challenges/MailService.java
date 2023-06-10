package com.kodilla.good.patterns.challenges;

public class MailService implements InformationService {
    @Override
    public void inform(User user) {
        String email = user.getEmail();
        String message = "Dear " + user.getUsername() + ",\n"
                + "Thank you for your purchase! Your order has been successfully processed.\n";
        // Code to send email to user.

        System.out.println("Sent purchase information to " + email);
    }
}