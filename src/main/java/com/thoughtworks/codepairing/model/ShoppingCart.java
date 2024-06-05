package com.thoughtworks.codepairing.model;

import java.util.List;
import java.util.stream.Collectors;

public class ShoppingCart {
    private List<Product> products;
    private Customer customer;

    public ShoppingCart(Customer customer, List<Product> products) {
        this.customer = customer;
        this.products = products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public Order checkout() {
        int totalPrice = 0;

        int loyaltyPointsEarned = 0;
        for (Product product : products) {
            int discountCents = 0;
            if (product.getProductCode().startsWith("DIS_10")) {
                discountCents = (int) (product.getPriceCents() * 0.1);
                loyaltyPointsEarned += (product.getPriceCents() / 1000);
            } else if (product.getProductCode().startsWith("DIS_15")) {
                discountCents = (int) (product.getPriceCents() * 0.15);
                loyaltyPointsEarned += (product.getPriceCents() / 1500);
            } else {
                loyaltyPointsEarned += (product.getPriceCents() / 500);
            }

            totalPrice += product.getPriceCents() - discountCents;
        }

        return new Order(totalPrice, loyaltyPointsEarned);
    }

    @Override
    public String toString() {
        return "Customer: " + customer.getName() + "\n" + "Bought:  \n" +
                products.stream().map(p -> "- " + p.getName()+ ", "+p.getPriceCents()/100 + "." + p.getPriceCents()%100).collect(Collectors.joining("\n"));
    }
}
