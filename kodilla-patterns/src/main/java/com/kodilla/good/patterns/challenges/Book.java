package com.kodilla.good.patterns.challenges;

import static com.kodilla.good.patterns.challenges.PurchaseCategories.BOOKS_AND_COMICS;

public class Book implements Product {
    private String name;
    private double price;
    private String category;

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
        this.category = BOOKS_AND_COMICS;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getCategory() {
        return category;
    }
}
