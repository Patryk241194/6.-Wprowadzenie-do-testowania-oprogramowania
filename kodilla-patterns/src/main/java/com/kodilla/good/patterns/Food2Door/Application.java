package com.kodilla.good.patterns.Food2Door;

import com.kodilla.good.patterns.Food2Door.customer.User;
import com.kodilla.good.patterns.Food2Door.informationservice.MailService;
import com.kodilla.good.patterns.Food2Door.orderprocessor.ExtraFoodShopProcessor;
import com.kodilla.good.patterns.Food2Door.orderprocessor.ProductOrderService;
import com.kodilla.good.patterns.Food2Door.purchase.PurchaseRequest;
import com.kodilla.good.patterns.Food2Door.purchase.PurchaseRequestRetriever;
import com.kodilla.good.patterns.Food2Door.purchase.ShoppingCart;
import com.kodilla.good.patterns.Food2Door.purchase.repository.ExtraFoodShopPurchaseRepository;
import com.kodilla.good.patterns.Food2Door.supplier.ExtraFoodShop;
import com.kodilla.good.patterns.Food2Door.supplier.Supplier;


public class Application {
    public static void main(String[] args) {
        PurchaseRequestRetriever purchaseRequestRetriever = new PurchaseRequestRetriever();
        User user1 = new User("Patryk123", "Patryk", "Potrykus",
                510033081, "patryk@gmail.com", true);
        Supplier supplier1 = new ExtraFoodShop();
        ShoppingCart shoppingCartOfUser1 = new ShoppingCart(user1, supplier1);
        shoppingCartOfUser1.putProduct(supplier1.getProductByName("Product 1"), 5);
        shoppingCartOfUser1.putProduct(supplier1.getProductByName("Product 2"), 3);

        PurchaseRequest purchaseRequest = purchaseRequestRetriever.retrieve(shoppingCartOfUser1);

        ProductOrderService orderService = new ProductOrderService(
                new MailService(), new ExtraFoodShopProcessor(), new ExtraFoodShopPurchaseRepository());
        orderService.process(purchaseRequest);
    }
}

