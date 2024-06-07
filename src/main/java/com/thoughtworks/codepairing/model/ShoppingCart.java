package com.thoughtworks.codepairing.model;

import org.javamoney.moneta.Money;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
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
        CurrencyUnit USD = Monetary.getCurrency("USD");
        MonetaryAmount totalPrice = Money.of(0, USD);

        int loyaltyPointsEarned = 0;
        for (Product product : products) {
            MonetaryAmount discount = Money.of(0, USD);
            if (product.getProductCode().startsWith("DIS_10")) {
                discount = (product.getPrice().multiply(0.1));
                loyaltyPointsEarned += (product.getPrice().divide(10)).getNumber().intValue();
            } else if (product.getProductCode().startsWith("DIS_15")) {
                discount = (product.getPrice().multiply(0.15));
                loyaltyPointsEarned += (product.getPrice().divide(15)).getNumber().intValue();
            } else {
                loyaltyPointsEarned += (product.getPrice().divide(5)).getNumber().intValue();
            }

            totalPrice = totalPrice.add(product.getPrice().subtract(discount));
        }

        return new Order(totalPrice, loyaltyPointsEarned);
    }

    @Override
    public String toString() {
        return "Customer: " + customer.getName() + "\n" + "Bought:  \n" + products.stream().map(p -> "- " + p.getName() + ", " + p.getPrice()).collect(Collectors.joining("\n"));
    }
}
