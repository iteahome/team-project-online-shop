package com.shop.model;

/** Product class - the "purpose" of the shop. */

public class Product {

//  Product parameters:
    private String productName;
    private String category;
    private String price;
    private String quantity;

//  Product class constructor:
    public Product(String productName, String category, String price, String quantity) {
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

//  Product getters and setters:
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

}