package com.thoughtworks.codepairing.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingCartTest {

    public static final int PRICE_CENT = 100_00;
    public static final String PRODUCT = "Product";

    Customer customer;

    @BeforeEach
    public void setUp() {
        customer = new Customer("test");
    }

    @Test
    public void shouldCalculatePriceWithNoDiscount() {
        List<Product> products = List.of(new Product(PRICE_CENT, "", PRODUCT));
        ShoppingCart cart = new ShoppingCart(customer, products);
        Order order = cart.checkout();

        assertEquals(100_00, order.getTotalPriceCents());
    }

    @Test
    public void shouldCalculateLoyaltyPointsWithNoDiscount() {
        List<Product> products = List.of(new Product(PRICE_CENT, "", PRODUCT));
        ShoppingCart cart = new ShoppingCart(customer, products);
        Order order = cart.checkout();

        assertEquals(20, order.getLoyaltyPoints());
    }

    @Test
    public void shouldCalculatePriceFor10PercentDiscount() {
        List<Product> products = List.of(new Product(PRICE_CENT, "DIS_10_ABCD", PRODUCT));
        ShoppingCart cart = new ShoppingCart(customer, products);
        Order order = cart.checkout();

        assertEquals(90_00, order.getTotalPriceCents());
    }

    @Test
    public void shouldCalculateLoyaltyPointsFor10PercentDiscount() {
        List<Product> products = List.of(new Product(PRICE_CENT, "DIS_10_ABCD", PRODUCT));
        ShoppingCart cart = new ShoppingCart(customer, products);
        Order order = cart.checkout();

        assertEquals(10, order.getLoyaltyPoints());
    }

    @Test
    public void shouldCalculatePriceFor15PercentDiscount() {
        List<Product> products = List.of(new Product(PRICE_CENT, "DIS_15_ABCD", PRODUCT));
        ShoppingCart cart = new ShoppingCart(customer, products);
        Order order = cart.checkout();

        assertEquals(8500, order.getTotalPriceCents(), 0.0);
    }

    @Test
    public void shouldCalculateLoyaltyPointsFor15PercentDiscount() {
        List<Product> products = List.of(new Product(PRICE_CENT, "DIS_15_ABCD", PRODUCT));
        ShoppingCart cart = new ShoppingCart(customer, products);
        Order order = cart.checkout();

        assertEquals(6, order.getLoyaltyPoints());
    }
}
