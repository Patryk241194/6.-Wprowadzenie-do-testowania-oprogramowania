package com.kodilla.good.patterns.Food2Door.purchase.repository;

import com.kodilla.good.patterns.Food2Door.products.Product;

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