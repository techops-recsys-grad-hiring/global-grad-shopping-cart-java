package com.thoughtworks.codepairing.service;

import com.thoughtworks.codepairing.model.Customer;
import com.thoughtworks.codepairing.model.Product;
import com.thoughtworks.codepairing.model.ShoppingCart;

import java.util.List;

public class ShoppingCartService {

    public void checkout(Customer customer, List<Product> products) {
        ShoppingCart cart = new ShoppingCart(customer, products, "OPEN");

        cart.checkout();
    }
}
