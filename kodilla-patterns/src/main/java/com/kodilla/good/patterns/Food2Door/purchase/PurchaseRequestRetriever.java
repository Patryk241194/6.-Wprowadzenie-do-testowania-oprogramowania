package com.kodilla.good.patterns.Food2Door.purchase;

import java.time.LocalDateTime;


public class PurchaseRequestRetriever {

    public PurchaseRequest retrieve(ShoppingCart shoppingCart) {
        LocalDateTime purchaseTime = LocalDateTime.now();
        return new PurchaseRequest(shoppingCart.getSupplier(), purchaseTime, shoppingCart.getProducts(), shoppingCart.getUser());
    }
}