package com.thoughtworks.codepairing.model;

import com.thoughtworks.codepairing.model.Customer;
import com.thoughtworks.codepairing.model.Product;
import com.thoughtworks.codepairing.model.ShoppingCart;

import java.util.List;

public class Order extends ShoppingCart {
    public Order(Customer customer, List<Product> products) {
        super(customer, products, "ORDER_PLACED");
    }
}
