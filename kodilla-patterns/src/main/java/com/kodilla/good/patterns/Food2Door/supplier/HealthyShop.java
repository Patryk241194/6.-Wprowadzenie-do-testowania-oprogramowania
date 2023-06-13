package com.kodilla.good.patterns.Food2Door.supplier;

import com.kodilla.good.patterns.Food2Door.products.Product;
import com.kodilla.good.patterns.Food2Door.products.ProductImplementation;

import java.util.HashMap;
import java.util.Map;

import static com.kodilla.good.patterns.Food2Door.products.productcatalog.HealthyShopList.CATEGORY_1;
import static com.kodilla.good.patterns.Food2Door.products.productcatalog.HealthyShopList.CATEGORY_2;
import static com.kodilla.good.patterns.Food2Door.products.productcatalog.HealthyShopList.PRODUCT_1;
import static com.kodilla.good.patterns.Food2Door.products.productcatalog.HealthyShopList.PRODUCT_2;
import static com.kodilla.good.patterns.Food2Door.products.productcatalog.HealthyShopList.PRODUCT_3;
import static com.kodilla.good.patterns.Food2Door.products.productcatalog.HealthyShopList.PRODUCT_4;

public class HealthyShop implements Supplier {
    private final String name = "HealthyShop";
    private final Map<Product, Integer> stock;

    public HealthyShop() {
        this.stock = createStock();
    }

    public Map<Product, Integer> createStock() {
        Map<Product, Integer> stock = new HashMap<>();
        Product product1 = new ProductImplementation(PRODUCT_1, 8.99, CATEGORY_1);
        Product product2 = new ProductImplementation(PRODUCT_2, 9.99, CATEGORY_1);
        Product product3 = new ProductImplementation(PRODUCT_3, 7.49, CATEGORY_2);
        Product product4 = new ProductImplementation(PRODUCT_4, 6.99, CATEGORY_2);
        stock.put(product1, 150);
        stock.put(product2, 200);
        stock.put(product3, 100);
        stock.put(product4, 300);
        return stock;
    }

    @Override
    public String getName() {
        return name;
    }


    @Override
    public double getDeliveryPrice() {
        return 10;
    }

    @Override
    public void displayMembershipOffer() {
        System.out.println("Special offer from HealthyShop members: Buy 3 of the same product, get 4th for free!");
    }


}