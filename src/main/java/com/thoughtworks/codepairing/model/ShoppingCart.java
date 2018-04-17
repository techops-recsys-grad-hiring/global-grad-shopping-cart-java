package com.thoughtworks.codepairing.model;

import com.thoughtworks.codepairing.service.OrderService;

import java.util.List;

public class ShoppingCart {
    //Product and quantity
    private List<Product> products;
    private Customer customer;
    private String cartState;

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    private OrderService orderService = new OrderService();

    public ShoppingCart(Customer customer, List<Product> products, String cartState) {
        this.customer = customer;
        this.products = products;
        this.cartState = cartState;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }


    public void checkout() {
        double totalPrice = 0;

        int loyaltyPointsEarned = 0;
        for (Product product : products) {
            double discount = 0;
            if (product.getProductCode().startsWith("DIS_10")) {
                discount = (product.getPrice() * 0.1);
                loyaltyPointsEarned += (product.getPrice() / 10);
            } else if (product.getProductCode().startsWith("DIS_15")) {
                discount = (product.getPrice() * 0.15);
                loyaltyPointsEarned += (product.getPrice() / 15);
            } else {
                loyaltyPointsEarned += (product.getPrice() / 5);
            }

            totalPrice += product.getPrice() - discount;
        }

        orderService.showConfirmation(customer, products, totalPrice, loyaltyPointsEarned);
    }


}
