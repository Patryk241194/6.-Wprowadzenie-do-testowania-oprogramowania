package com.kodilla.good.patterns.Food2Door.purchase.repository;

import com.kodilla.good.patterns.Food2Door.supplier.Supplier;
import com.kodilla.good.patterns.Food2Door.customer.User;
import com.kodilla.good.patterns.Food2Door.products.Product;

import java.time.LocalDateTime;
import java.util.Map;

public interface PurchaseRepository {
    void createPurchase(Supplier supplier, LocalDateTime purchaseTime, Map<Product, Integer> products, User user);
}
