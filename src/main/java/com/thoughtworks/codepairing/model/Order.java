package com.thoughtworks.codepairing.model;

import java.math.BigDecimal;

public class Order {
    private BigDecimal totalPrice;
    private int loyaltyPoints;

    public Order(BigDecimal totalPrice, int loyaltyPointsEarned) {
        this.totalPrice = totalPrice;
        this.loyaltyPoints = loyaltyPointsEarned;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    @Override
    public String toString() {
        return "Total price: " + totalPrice + "\n" + "Will receive " + loyaltyPoints + " loyalty points";
    }
}
