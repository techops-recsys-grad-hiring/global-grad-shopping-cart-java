package com.thoughtworks.codepairing;

import com.thoughtworks.codepairing.model.Customer;
import com.thoughtworks.codepairing.model.Product;
import com.thoughtworks.codepairing.model.ShoppingCart;
import com.thoughtworks.codepairing.service.OrderService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SampleApp {

    private static class ConsoleOrderService implements OrderService {
        @Override
        public void showConfirmation(Customer customer, List<Product> products, double totalPrice, int loyaltyPointsEarned) {
            System.out.println("Customer: " + customer.getName());
            System.out.println("Bought:  \n" + products.stream().map(p -> "- " + p.getName()+ ", "+p.getPrice()).collect(Collectors.joining("\n")));
            System.out.println("Total price: " + totalPrice);
            System.out.println("Will receive " + loyaltyPointsEarned + " loyalty points");
        }
    }

    public static void main(String[] args) {
        Product product1 = new Product(10.0, "DIS_10_PRODUCT1", "product 1");
        Product product2 = new Product(20.0, "DIS_10_PRODUCT2", "product 2");
        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        Customer customer = new Customer("A Customer");
        ShoppingCart shoppingCart = new ShoppingCart(customer, products);
        shoppingCart.setOrderService(new ConsoleOrderService());
        Product product3 = new Product(30.0, "DIS_10_PRODUCT3", "product 3");
        shoppingCart.addProduct(product3);
        shoppingCart.checkout();
    }
}
