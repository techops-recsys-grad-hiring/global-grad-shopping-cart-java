package com.thoughtworks.codepairing.service;

import com.thoughtworks.codepairing.model.Customer;
import com.thoughtworks.codepairing.model.Order;
import com.thoughtworks.codepairing.model.Product;
import com.thoughtworks.codepairing.model.ShoppingCart;

import java.util.List;

public class OrderService {

    public void showConfirmation(Customer customer, List<Product> products, double totalPrice, int loyaltyPointsEarned) {
        //show confirmation
        //do some calculations and formatting on the shopping cart data and ask user for confirmation
        //after confirmation redirect to place order
    }

    public ShoppingCart placeOrder(Customer customer, List<Product> products) {
        //place order
        return new Order(customer, products);
    }

}
