package com.thoughtworks.codepairing.model;

public class Product {
    private final int priceCents;
    private final String productCode;
    private final String name;

    public Product(int priceCents, String productCode, String name) {
        this.priceCents = priceCents;
        this.productCode = productCode;
        this.name = name;
    }

    public int getPriceCents() {
        return priceCents;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getName() {
        return name;
    }
}
