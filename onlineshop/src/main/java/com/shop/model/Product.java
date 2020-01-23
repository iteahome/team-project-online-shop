package com.shop.model;

// PRODUCT CLASS:
public class Product {
    private String productName;
    private String category;
    private double price;
    private int quantity;

    // PRODUCT CONSTRUCTOR:
    public Product(String productName, String category, double price, int quantity) {
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    // PRODUCT NAME GETTER AND SETTER:
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    // CATEGORY GETTER AND SETTER:
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    // PRICE GETTER AND SETTER:
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
