package com.kodilla.good.patterns.food2door.purchase;

import java.time.LocalDateTime;


public class PurchaseRequestRetriever {

    public PurchaseRequest retrieve(ShoppingCart shoppingCart) {
        LocalDateTime purchaseTime = LocalDateTime.now();
        return new PurchaseRequest(shoppingCart.getSupplier(), purchaseTime, shoppingCart.getProducts(), shoppingCart.getUser());
    }
}