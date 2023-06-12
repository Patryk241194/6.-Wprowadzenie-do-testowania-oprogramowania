package com.kodilla.good.patterns.Food2Door.supplier;

import com.kodilla.good.patterns.Food2Door.products.Product;

import java.util.Map;

public interface Supplier {

    String getName();

    Map<Product, Integer> createStock();

    default Map<Product, Integer> getStock() {
        return createStock();
    }

    default Product getProductByName(String productName) {
        for (Map.Entry<Product, Integer> entry : getStock().entrySet()) {
            Product product = entry.getKey();
            if (product.name().equals(productName)) {
                return product;
            }
        }
        return null;
    }

    double getDeliveryPrice();

    void displayMembershipOffer();

}
