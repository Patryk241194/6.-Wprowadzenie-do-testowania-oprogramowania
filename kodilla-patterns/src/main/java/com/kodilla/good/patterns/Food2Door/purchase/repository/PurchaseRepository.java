package com.kodilla.good.patterns.Food2Door.purchase.repository;

import com.kodilla.good.patterns.Food2Door.supplier.Supplier;
import com.kodilla.good.patterns.Food2Door.customer.User;
import com.kodilla.good.patterns.Food2Door.products.Product;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public interface PurchaseRepository {
    default void createPurchaseDatabase(Supplier supplier, LocalDateTime purchaseTime, Map<Product, Integer> products, User user) {
        Map<Product, Map<LocalDateTime, Integer>> purchaseDatabase = getPurchaseDatabase();

        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            Map<LocalDateTime, Integer> productPurchases = purchaseDatabase.getOrDefault(product, new HashMap<>());
            productPurchases.put(purchaseTime, quantity);
            purchaseDatabase.put(product, productPurchases);
        }
    }

    Map<Product, Map<LocalDateTime, Integer>> getPurchaseDatabase();
}
