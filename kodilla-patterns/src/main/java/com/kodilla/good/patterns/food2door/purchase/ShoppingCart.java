package com.kodilla.good.patterns.food2door.purchase;

import com.kodilla.good.patterns.food2door.customer.User;
import com.kodilla.good.patterns.food2door.products.Product;
import com.kodilla.good.patterns.food2door.supplier.Supplier;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private final Supplier supplier;
    private final User user;
    private final Map<Product, Integer> products;

    public ShoppingCart(User user, Supplier supplier) {
        this.user = user;
        this.supplier = supplier;
        products = new HashMap<>();
    }

    public void putProduct(Product product, int quantity) {
        if (supplier.getStock().containsKey(product)) {
            products.put(product, quantity);
        } else {
            System.out.println("This product is from another supplier. Please create a separate order.");
        }
    }

    public Map<Product, Integer> getProducts() {
        return new HashMap<>(products);
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public User getUser() {
        return user;
    }
}
