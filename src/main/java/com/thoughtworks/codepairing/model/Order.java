package com.thoughtworks.codepairing.model;

public class Order {
    double totalPrice;
    int loyaltyPoints;

    public Order(double totalPrice, int loyaltyPointsEarned) {
        this.totalPrice = totalPrice;
        this.loyaltyPoints = loyaltyPointsEarned;
    }

    @Override
    public String toString() {
        return "Total price: " + totalPrice + "\n" + "Will receive " + loyaltyPoints + " loyalty points";
    }
}
