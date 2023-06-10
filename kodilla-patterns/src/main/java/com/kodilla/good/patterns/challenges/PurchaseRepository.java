package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public interface PurchaseRepository {
    void createPurchase(User user, LocalDateTime purchaseTime, Product product);
}
