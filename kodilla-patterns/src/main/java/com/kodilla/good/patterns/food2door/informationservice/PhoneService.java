package com.kodilla.good.patterns.food2door.informationservice;

import com.kodilla.good.patterns.food2door.customer.User;

public class PhoneService implements InformationService {
    @Override
    public void inform(User user) {
        Integer phoneNumber = user.getPhoneNumber();
        String message = "Dear " + user.getUsername() + ",\n"
                + "Thank you for your purchase! Your order has been successfully processed.\n";

        System.out.println("Sent purchase information to " + phoneNumber);
    }
}