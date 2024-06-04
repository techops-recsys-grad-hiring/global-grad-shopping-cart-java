package com.thoughtworks.codepairing.model;

import java.math.BigDecimal;

public class Product {
    private final BigDecimal price;
    private final String productCode;
    private final String name;

    public Product(BigDecimal price, String productCode, String name) {
        this.price = price;
        this.productCode = productCode;
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getName() {
        return name;
    }
}
