package com.kodilla.good.patterns.food2door.purchase;

import com.kodilla.good.patterns.food2door.supplier.Supplier;
import com.kodilla.good.patterns.food2door.customer.User;
import com.kodilla.good.patterns.food2door.products.Product;

import java.time.LocalDateTime;
import java.util.Map;

public class PurchaseRequest {

    private User user;
    private LocalDateTime purchaseTime;
    private Map<Product, Integer> products;
    private Supplier supplier;

    public PurchaseRequest(Supplier supplier, LocalDateTime purchaseTime, Map<Product, Integer> products, User user) {
        this.user = user;
        this.purchaseTime = purchaseTime;
        this.products = products;
        this.supplier = supplier;
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getPurchaseTime() {
        return purchaseTime;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public Supplier getSupplier() {
        return supplier;
    }
}


