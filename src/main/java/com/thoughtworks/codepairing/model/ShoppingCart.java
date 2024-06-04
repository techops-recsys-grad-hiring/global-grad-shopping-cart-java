package com.thoughtworks.codepairing.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
        var totalPrice = BigDecimal.ZERO;

        int loyaltyPointsEarned = 0;
        for (Product product : products) {
            var discount = BigDecimal.ZERO;
            if (product.getProductCode().startsWith("DIS_10")) {
                discount = (product.getPrice().multiply(new BigDecimal("0.10")));
                loyaltyPointsEarned += (product.getPrice().divide(BigDecimal.valueOf(10), RoundingMode.DOWN).intValue());
            } else if (product.getProductCode().startsWith("DIS_15")) {
                discount = (product.getPrice().multiply(new BigDecimal("0.15")));
                loyaltyPointsEarned += (product.getPrice().divide(BigDecimal.valueOf(15), RoundingMode.DOWN).intValue());
            } else {
                loyaltyPointsEarned += (product.getPrice().divide(BigDecimal.valueOf(5), RoundingMode.DOWN)).intValue();
            }

            totalPrice = totalPrice.add(product.getPrice().subtract(discount));
        }

        return new Order(totalPrice, loyaltyPointsEarned);
    }

    @Override
    public String toString() {
        return "Customer: " + customer.getName() + "\n" + "Bought:  \n" + products.stream().map(p -> "- " + p.getName()+ ", "+p.getPrice()).collect(Collectors.joining("\n"));
    }
}
