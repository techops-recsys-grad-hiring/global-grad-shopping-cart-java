package com.thoughtworks.codepairing.model;

import com.thoughtworks.codepairing.service.OrderService;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class ShoppingCartTest {

    @Test
    public void shouldValidateInformationPassedOnToConfirmation() {
        ShoppingCart cart = new ShoppingCart(new Customer("test"), asList(new Product(100, "DIS_10_ABCD", "T")));
        FakeOrderService fakeOrderService = new FakeOrderService();
        cart.setOrderService(fakeOrderService);
        cart.checkout();

        assertEquals(90.0, fakeOrderService.actualTotalPrice, 0.0);
    }

    class FakeOrderService implements OrderService {
        double actualTotalPrice;

        @Override
        public void showConfirmation(Customer customer, List<Product> products, double totalPrice, int loyaltyPointsEarned) {
            this.actualTotalPrice = totalPrice;
        }
    }
}