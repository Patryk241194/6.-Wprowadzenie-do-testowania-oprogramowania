package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public interface PurchaseService {
    boolean purchase(User user, LocalDateTime purchaseTime, Product product);
}
