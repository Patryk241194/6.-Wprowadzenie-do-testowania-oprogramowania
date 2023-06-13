package com.kodilla.good.patterns.food2door.purchase.repository;

import com.kodilla.good.patterns.food2door.products.Product;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class HealthyShopPurchaseRepository implements PurchaseRepository {
    private Map<Product, Map<LocalDateTime, Integer>> purchaseDatabase;

    public HealthyShopPurchaseRepository() {
        this.purchaseDatabase = new HashMap<>();
    }

    @Override
    public Map<Product, Map<LocalDateTime, Integer>> getPurchaseDatabase() {
        return purchaseDatabase;
    }
}