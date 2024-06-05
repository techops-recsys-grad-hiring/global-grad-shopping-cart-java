package com.thoughtworks.codepairing.model;

public class Order {
    private int totalPriceCents;
    private int loyaltyPoints;

    public Order(int totalPriceCents, int loyaltyPointsEarned) {
        this.totalPriceCents = totalPriceCents;
        this.loyaltyPoints = loyaltyPointsEarned;
    }

    public int getTotalPriceCents() {
        return totalPriceCents;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    @Override
    public String toString() {
        return "Total price: " + totalPriceCents / 100 + "." + totalPriceCents % 100 + "\n" + "Will receive " + loyaltyPoints + " loyalty points";
    }
}
