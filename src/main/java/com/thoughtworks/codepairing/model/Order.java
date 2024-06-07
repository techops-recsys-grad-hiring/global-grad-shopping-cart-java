package com.thoughtworks.codepairing.model;

import javax.money.MonetaryAmount;

public class Order {
    private MonetaryAmount totalPrice;
    private int loyaltyPoints;

    public Order(MonetaryAmount totalPrice, int loyaltyPointsEarned) {
        this.totalPrice = totalPrice;
        this.loyaltyPoints = loyaltyPointsEarned;
    }

    public MonetaryAmount getTotalPrice() {
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
