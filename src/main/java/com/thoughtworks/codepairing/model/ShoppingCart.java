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


    /*
        Checkout: Calculates total price and total loyalty points earned by the customer.
        Products with product code starting with DIS_10 have a 10% discount applied.
        Products with product code starting with DIS_15 have a 15% discount applied.

        Loyalty points are earned more when the product is not under any offer.
            Customer earns 1 point on every $5 purchase.
            Customer earns 1 point on every $10 spent on a product with 10% discount.
            Customer earns 1 point on every $15 spent on a product with 15% discount.
    */

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
