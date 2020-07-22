package com.thoughtworks.codepairing.service;

import com.thoughtworks.codepairing.model.Customer;
import com.thoughtworks.codepairing.model.Product;

import java.util.List;

public interface OrderService {

    default void showConfirmation(Customer customer, List<Product> products, double totalPrice, int loyaltyPointsEarned) {
    }
}
