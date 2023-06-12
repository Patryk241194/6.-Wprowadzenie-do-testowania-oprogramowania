package com.kodilla.good.patterns.Food2Door.supplier;

import com.kodilla.good.patterns.Food2Door.products.Product;
import com.kodilla.good.patterns.Food2Door.products.ProductImplementation;

import java.util.HashMap;
import java.util.Map;

import static com.kodilla.good.patterns.Food2Door.products.listOfCategoriesAndProducts.GlutenFreeShopList.*;

public class GlutenFreeShop implements Supplier {
    private final String name = "GlutenFreeShop";
    private final Map<Product, Integer> stock;

    public GlutenFreeShop() {
        this.stock = createStock();
    }

    public Map<Product, Integer> createStock() {
        Map<Product, Integer> stock = new HashMap<>();
        Product product1 = new ProductImplementation(PRODUCT_1, 5.99, CATEGORY_1);
        Product product2 = new ProductImplementation(PRODUCT_2, 7.99, CATEGORY_1);
        Product product3 = new ProductImplementation(PRODUCT_3, 8.49, CATEGORY_2);
        Product product4 = new ProductImplementation(PRODUCT_4, 9.49, CATEGORY_2);
        stock.put(product1, 300);
        stock.put(product2, 250);
        stock.put(product3, 150);
        stock.put(product4, 200);
        return stock;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getDeliveryPrice() {
        return 5;
    }

    @Override
    public void displayMembershipOffer() {
        System.out.println("Special offer from GlutenFreeShop members: Free shipping on orders above $50!");
    }
}
