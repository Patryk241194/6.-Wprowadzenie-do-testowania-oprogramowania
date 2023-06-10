package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

import static com.kodilla.good.patterns.challenges.PurchaseCategories.BOOKS_AND_COMICS;

public class BookPurchaseService implements PurchaseService {
    @Override
    public boolean purchase(User user, LocalDateTime purchaseTime, Product product) {
        if (product.getCategory().equals(BOOKS_AND_COMICS)) {
            // Logic specific to the purchase of books and comics
            System.out.println("Book or comic purchase successful!");
            return true;
        } else {
            System.out.println("Purchase failed!");
            return false;
        }
    }
}
