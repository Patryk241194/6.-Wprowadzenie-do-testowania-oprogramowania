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

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;

        if (Double.compare(book.getPrice(), getPrice()) != 0) return false;
        if (getName() != null ? !getName().equals(book.getName()) : book.getName() != null) return false;
        return getCategory() != null ? getCategory().equals(book.getCategory()) : book.getCategory() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getName() != null ? getName().hashCode() : 0;
        temp = Double.doubleToLongBits(getPrice());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (getCategory() != null ? getCategory().hashCode() : 0);
        return result;
    }
}
