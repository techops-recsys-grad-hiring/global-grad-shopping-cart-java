package com.thoughtworks.codepairing.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ShoppingCart {
    private List<Product> products;
    private Customer customer;

    public ShoppingCart(Customer customer, List<Product> products) {
        this.customer = customer;
        this.products = products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public Order checkout() {
        double totalPrice = 0;
        int loyaltyPointsEarned = 0;

        Map<String, List<Product>> productCodeMap = products.stream()
                .collect(Collectors.groupingBy(product -> product.getProductCode()));


        for (Map.Entry<String, List<Product>> products : productCodeMap.entrySet()) {
            String productCode = products.getKey();
            List<Product> productList = products.getValue();
            double price = productList.get(0).getPrice();

            int productCount = productList.size();

            double discount = 0;
            if (productCode.startsWith("DIS_10")) {
                discount = (price * 0.1);
                loyaltyPointsEarned += (price / 10);
            } else if (productCode.startsWith("DIS_15")) {
                discount = (price * 0.15);
                loyaltyPointsEarned += (price / 15);
            }  else if (productCode.startsWith("DIS_20")) {
                discount = (price * 0.20);
                loyaltyPointsEarned += (price / 20);
            } else if (productCode.startsWith("BULK_BUY_2_GET_1")) {
                discount = (productCount / 3) * price;
                //loyaltyPointsEarned += (price / 20);
            } else {
                loyaltyPointsEarned += (price / 5);
            }

            totalPrice = totalPrice + (price * productCount) - discount;
        }

        return new Order(totalPrice, loyaltyPointsEarned);
    }

    @Override
    public String toString() {
        return "Customer: " + customer.getName() + "\n" + "Bought:  \n" + products.stream().map(p -> "- " + p.getName()+ ", "+p.getPrice()).collect(Collectors.joining("\n"));
    }
}
