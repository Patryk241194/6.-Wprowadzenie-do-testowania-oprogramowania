package com.kodilla.good.patterns.Food2Door.informationService;


import com.kodilla.good.patterns.Food2Door.customer.User;

public class MailService implements InformationService {
    @Override
    public void inform(User user) {
        String email = user.getEmail();
        String message = "Dear " + user.getUsername() + ",\n"
                + "Thank you for your purchase! Your order has been successfully processed.\n";

        System.out.println("\nSent purchase information to " + email);
    }
}