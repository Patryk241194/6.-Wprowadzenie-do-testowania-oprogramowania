package com.kodilla.good.patterns.Food2Door.informationservice;

import com.kodilla.good.patterns.Food2Door.customer.User;

public class PhoneService implements InformationService {
    @Override
    public void inform(User user) {
        Integer phoneNumber = user.getPhoneNumber();
        String message = "Dear " + user.getUsername() + ",\n"
                + "Thank you for your purchase! Your order has been successfully processed.\n";

        System.out.println("Sent purchase information to " + phoneNumber);
    }
}