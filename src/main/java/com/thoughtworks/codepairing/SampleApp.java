package com.thoughtworks.codepairing;

import com.thoughtworks.codepairing.model.Customer;
import com.thoughtworks.codepairing.model.Product;
import com.thoughtworks.codepairing.model.ShoppingCart;
import com.thoughtworks.codepairing.model.Order;

import java.util.ArrayList;
import java.util.List;

public class SampleApp {
    public static void main(String[] args) {
        Product product1 = new Product(10.0, "DIS_10_PRODUCT1", "product 1");
        Product product2 = new Product(20.0, "DIS_10_PRODUCT2", "product 2");

        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);

        Customer customer = new Customer("A Customer");

        ShoppingCart shoppingCart = new ShoppingCart(customer, products);
        Product product3 = new Product(30.0, "DIS_10_PRODUCT3", "product 3");
        shoppingCart.addProduct(product3);
        System.out.println(shoppingCart.toString());

        Order order = shoppingCart.checkout();
        System.out.println(order.toString());
    }
}
