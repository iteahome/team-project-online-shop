package com.shop.model;


/** Product class - the "purpose" of the shop. */

public class Product implements Writable{

//  Product parameters:
    private int id;
    private String name;
    private String category;
    private String price;
    private String stock;
    private int uniqueProdId;

//  Product class constructor:
    public Product(String name, String category, String price, String stock, int uniqueProdId) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
        this.uniqueProdId = uniqueProdId;
    }

    @Override
    public String toString (){
        return "Name: " + name + ", Category: " + category + ", Price: " + price + ", ProductId: " + uniqueProdId;
    }
    public String dbPrint() {
        return name + "|" + category + "|" + price + "|" + uniqueProdId + "|" + stock;
    }


//  Product getters and setters:
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toDb() {
        return name + "|" + category + "|" + price + "|" + uniqueProdId + "|" + stock;
    }
}