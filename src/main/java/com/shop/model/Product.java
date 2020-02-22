package com.shop.model;


/** Product class - the "purpose" of the shop. */

public class Product {

//  Product parameters:
    private String productName;
    private String category;
    private String price;
    private String stock;
    private int uniqueProdId;

//  Product class constructor:
    public Product(String productName, String category, String price, String stock, int uniqueProdId) {
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.stock = stock;
        this.uniqueProdId = uniqueProdId;
    }

    @Override
    public String toString (){
        return "Name: " + productName + ", Category: " + category + ", Price: " + price + ", ProductId: " + uniqueProdId;
    }
    public String DBprint () {
        return productName + "|" + category + "|" + price + "|" + uniqueProdId + "|" + stock;
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

    public String getStock() {
        return stock;
    }
    public void setStock(String stock) {
        this.stock = stock;
    }
    public int getUniqueProdId() {
        return uniqueProdId;
    }

}