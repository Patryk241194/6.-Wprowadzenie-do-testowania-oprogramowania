package com.kodilla.good.patterns.Food2Door.purchase;

import com.kodilla.good.patterns.Food2Door.customer.User;
import com.kodilla.good.patterns.Food2Door.products.Product;
import com.kodilla.good.patterns.Food2Door.supplier.Supplier;

import java.time.LocalDateTime;
import java.util.Map;

public class PurchaseRequestRetriever {

    public PurchaseRequest retrieve(ShoppingCart shoppingCart) {
        LocalDateTime purchaseTime = LocalDateTime.now();
        return new PurchaseRequest(shoppingCart.getSupplier(), purchaseTime, shoppingCart.getProducts(), shoppingCart.getUser());
    }
}