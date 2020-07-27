package com.thoughtworks.codepairing.model;

import com.thoughtworks.codepairing.service.OrderService;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class ShoppingCartTest {

    public static final int PRICE = 100;
    public static final String PRODUCT = "Product";

    Customer customer;
    FakeOrderService fakeOrderService;

    @Before
    public void setUp() throws Exception {
        customer = new Customer("test");
        fakeOrderService = new FakeOrderService();
    }

    @Test
    public void shouldCalculatePriceWithNoDiscount() {
        List<Product> products = asList(new Product(PRICE, "", PRODUCT));
        ShoppingCart cart = new ShoppingCart(customer, products);
        cart.setOrderService(fakeOrderService);
        cart.checkout();

        assertEquals(100.0, fakeOrderService.actualTotalPrice, 0.0);
    }

    @Test
    public void shouldCalculateLoyaltyPointsWithNoDiscount() {
        List<Product> products = asList(new Product(PRICE, "", PRODUCT));
        ShoppingCart cart = new ShoppingCart(customer, products);
        cart.setOrderService(fakeOrderService);
        cart.checkout();

        assertEquals(20, fakeOrderService.actualLoyaltyPoints);
    }

    @Test
    public void shouldCalculatePriceFor10PercentDiscount() {
        List<Product> products = asList(new Product(PRICE, "DIS_10_ABCD", PRODUCT));
        ShoppingCart cart = new ShoppingCart(customer, products);
        cart.setOrderService(fakeOrderService);
        cart.checkout();

        assertEquals(90.0, fakeOrderService.actualTotalPrice, 0.0);
    }

    @Test
    public void shouldCalculateLoyaltyPointsFor10PercentDiscount() {
        List<Product> products = asList(new Product(PRICE, "DIS_10_ABCD", PRODUCT));
        ShoppingCart cart = new ShoppingCart(customer, products);
        cart.setOrderService(fakeOrderService);
        cart.checkout();

        assertEquals(10, fakeOrderService.actualLoyaltyPoints);
    }

    @Test
    public void shouldCalculatePriceFor15PercentDiscount() {
        List<Product> products = asList(new Product(PRICE, "DIS_15_ABCD", PRODUCT));
        ShoppingCart cart = new ShoppingCart(customer, products);
        cart.setOrderService(fakeOrderService);
        cart.checkout();

        assertEquals(85.0, fakeOrderService.actualTotalPrice, 0.0);
    }

    @Test
    public void shouldCalculateLoyaltyPointsFor15PercentDiscount() {
        List<Product> products = asList(new Product(PRICE, "DIS_15_ABCD", PRODUCT));
        ShoppingCart cart = new ShoppingCart(customer, products);
        cart.setOrderService(fakeOrderService);
        cart.checkout();

        assertEquals(6, fakeOrderService.actualLoyaltyPoints);
    }

    class FakeOrderService implements OrderService {
        double actualTotalPrice;
        int actualLoyaltyPoints;

        @Override
        public void showConfirmation(Customer customer, List<Product> products, double totalPrice, int loyaltyPointsEarned) {
            this.actualTotalPrice = totalPrice;
            this.actualLoyaltyPoints = loyaltyPointsEarned;
        }
    }
}