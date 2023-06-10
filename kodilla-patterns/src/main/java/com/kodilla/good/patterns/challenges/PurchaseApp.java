package com.kodilla.good.patterns.challenges;

public class PurchaseApp {
    public static void main(String[] args) {
        PurchaseRequestRetriever purchaseRequestRetriever = new PurchaseRequestRetriever();
        PurchaseRequest purchaseRequest = purchaseRequestRetriever.retrieve();

        ProductOrderService orderService = new ProductOrderService(
                new MailService(), new BookPurchaseService(), new BookPurchaseRepository());
        orderService.process(purchaseRequest);
    }
}

