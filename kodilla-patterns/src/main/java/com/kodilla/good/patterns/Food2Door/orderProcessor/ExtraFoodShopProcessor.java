package com.kodilla.good.patterns.Food2Door.orderProcessor;

import com.kodilla.good.patterns.Food2Door.customer.User;
import com.kodilla.good.patterns.Food2Door.products.Product;
import com.kodilla.good.patterns.Food2Door.supplier.ExtraFoodShop;
import com.kodilla.good.patterns.Food2Door.supplier.Supplier;

import java.time.LocalDateTime;
import java.util.Map;

public class ExtraFoodShopProcessor implements OrderProcessor {
    @Override
    public boolean process(Supplier supplier, LocalDateTime purchaseTime, Map<Product, Integer> products, User user) {
        Supplier extraFoodShop = new ExtraFoodShop();

        double totalPrice = calculateTotalPrice(products, supplier.getDeliveryPrice());

        if (user.isMembershipActive()) {
            totalPrice = applyMembershipDiscount(totalPrice);
        }

        displayOrderSummary(supplier, totalPrice, products);

        updateStock(extraFoodShop, products);

        return true;
    }

    private double applyMembershipDiscount(double totalPrice) {
        double discount = totalPrice * 0.1;
        return totalPrice - discount;
    }
}

