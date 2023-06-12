package com.kodilla.good.patterns.Food2Door.purchase;

import com.kodilla.good.patterns.Food2Door.customer.User;

public class PurchaseDto {
    private User user;
    private boolean isPurchased;

    public PurchaseDto(final User user, final boolean isPurchased) {
        this.user = user;
        this.isPurchased = isPurchased;
    }

    public User getUser() {
        return user;
    }

    public boolean isPurchased() {
        return isPurchased;
    }

}
