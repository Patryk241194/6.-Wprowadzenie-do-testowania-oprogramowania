package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class PurchaseRequestRetriever {

    public PurchaseRequest retrieve() {
        User user = new User("Patryk123", "Patryk", "Potrykus",
                510033081, "patryk@gmail.com");

        LocalDateTime purchaseTime = LocalDateTime.now();

        Product product = new Book("Lord Of The Rings",69.99);

        return new PurchaseRequest(user, purchaseTime, product);
    }

}
