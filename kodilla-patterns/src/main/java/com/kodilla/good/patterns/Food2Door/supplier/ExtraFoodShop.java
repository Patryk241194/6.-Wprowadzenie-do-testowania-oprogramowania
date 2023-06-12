package com.kodilla.good.patterns.Food2Door.supplier;

import com.kodilla.good.patterns.Food2Door.products.Product;
import com.kodilla.good.patterns.Food2Door.products.ProductImplementation;

import java.util.HashMap;
import java.util.Map;

import static com.kodilla.good.patterns.Food2Door.products.listOfCategoriesAndProducts.ExtraFoodShopList.*;

public class ExtraFoodShop implements Supplier {
    private final String name = "ExtraFoodShop";
    private final Map<Product, Integer> stock;

    public ExtraFoodShop() {
        this.stock = createStock();
    }

    public Map<Product, Integer> createStock() {
        Map<Product, Integer> stock = new HashMap<>();
        Product product1 = new ProductImplementation(PRODUCT_1, 5.99, CATEGORY_1);
        Product product2 = new ProductImplementation(PRODUCT_2, 7.49, CATEGORY_1);
        Product product3 = new ProductImplementation(PRODUCT_3, 8.99, CATEGORY_2);
        Product product4 = new ProductImplementation(PRODUCT_4, 9.99, CATEGORY_2);

        stock.putAll(Map.of(
                product1, 600,
                product2, 250,
                product3, 300,
                product4, 560
        ));

        return stock;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getDeliveryPrice() {
        return 15;
    }

    @Override
    public void displayMembershipOffer() {
        System.out.println("Special offer from ExtraFoodShop members: 10% off your entire order!");
    }
}
