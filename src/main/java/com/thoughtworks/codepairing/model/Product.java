package com.thoughtworks.codepairing.model;

import javax.money.MonetaryAmount;

public class Product {
    private final MonetaryAmount price;
    private final String productCode;
    private final String name;

    public Product(MonetaryAmount price, String productCode, String name) {
        this.price = price;
        this.productCode = productCode;
        this.name = name;
    }

    public MonetaryAmount getPrice() {
        return price;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getName() {
        return name;
    }
}
