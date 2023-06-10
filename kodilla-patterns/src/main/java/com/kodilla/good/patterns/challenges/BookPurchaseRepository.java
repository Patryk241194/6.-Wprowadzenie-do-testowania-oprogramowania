package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

import static com.kodilla.good.patterns.challenges.PurchaseCategories.BOOKS_AND_COMICS;

public class BookPurchaseRepository implements PurchaseRepository {
    @Override
    public void createPurchase(User user, LocalDateTime purchaseTime, Product product) {
        if (product.getCategory().equals(BOOKS_AND_COMICS)) {
            // Logic specific to saving book and comic purchases
            System.out.println("Book or comic purchase saved successfully!");
        } else {
            System.out.println("Purchase not saved!");
        }
    }
}
