package com.kodilla.good.patterns.food2door.orderprocessor;

import com.kodilla.good.patterns.food2door.customer.User;
import com.kodilla.good.patterns.food2door.products.Product;
import com.kodilla.good.patterns.food2door.supplier.Supplier;

import java.time.LocalDateTime;
import java.util.Map;

public interface OrderProcessor {
    boolean process(Supplier supplier, LocalDateTime purchaseTime, Map<Product, Integer> products, User user);

    default double calculateTotalPrice(Map<Product, Integer> products, double deliveryPrice) {
        double totalPrice = 0.0;

        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            totalPrice += product.price() * quantity;
        }

        totalPrice += deliveryPrice;
        return totalPrice;
    }

    default void displayOrderSummary(Supplier supplier, double totalPrice, Map<Product, Integer> products) {
        System.out.println("\nProcessing order for " + supplier.getName() + ":");
        supplier.displayMembershipOffer();
        System.out.println("\nTotal price: " + String.format("%.2f", totalPrice) + "$");
        System.out.println("Purchased products:");

        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            System.out.println("- " + product.name() + ", price: " + product.price() + ", quantity: " + quantity);
        }
    }

    default void updateStock(Supplier supplier, Map<Product, Integer> products) {
        Map<Product, Integer> stock = supplier.getStock();

        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            int quantityOrdered = entry.getValue();

            if (stock.containsKey(product)) {
                int quantityInStock = stock.get(product);
                int updatedQuantity = quantityInStock - quantityOrdered;
                stock.put(product, updatedQuantity);
            }
        }
    }
}

