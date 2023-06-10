package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class PurchaseRequest {

    private User user;
    private LocalDateTime purchaseTime;
    private Product product;

    public PurchaseRequest(User user, LocalDateTime purchaseTime, Product product) {
        this.user = user;
        this.purchaseTime = purchaseTime;
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getPurchaseTime() {
        return purchaseTime;
    }

    public Product getProduct() {
        return product;
    }
}
