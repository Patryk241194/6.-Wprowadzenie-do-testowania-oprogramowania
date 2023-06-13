package com.kodilla.good.patterns.Food2Door.orderprocessor;

import com.kodilla.good.patterns.Food2Door.customer.User;
import com.kodilla.good.patterns.Food2Door.products.Product;
import com.kodilla.good.patterns.Food2Door.supplier.HealthyShop;
import com.kodilla.good.patterns.Food2Door.supplier.Supplier;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class HealthyShopProcessor implements OrderProcessor {
    @Override
    public boolean process(Supplier supplier, LocalDateTime purchaseTime, Map<Product, Integer> products, User user) {
        Supplier healthyShop = new HealthyShop();

        double totalPrice = calculateTotalPrice(products, supplier.getDeliveryPrice());

        if (user.isMembershipActive() && products.size() >= 3) {
            totalPrice = applyMembershipOffer(totalPrice, products);
        }

        displayOrderSummary(supplier, totalPrice, products);

        updateStock(healthyShop, products);

        return true;
    }

    private double applyMembershipOffer(double totalPrice, Map<Product, Integer> products) {
        List<Product> sortedProducts = new ArrayList<>(products.keySet());
        sortedProducts.sort(Comparator.comparingDouble(Product::price));

        int totalQuantity = products.values().stream().mapToInt(Integer::intValue).sum();
        int freeItems = totalQuantity / 3;
        double discount = 0.0;

        for (int i = 0; i < freeItems; i++) {
            Product product = sortedProducts.get(i);
            discount += product.price();
        }

        return totalPrice - discount;
    }
}