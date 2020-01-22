package com.shop.model;

import java.util.ArrayList;

// SHOPPING CART CLASS (WILL STORE PRODUCTS TEMPORARILY):
public class Cart {
    private int cartId;
    private ArrayList cartContent;

    // CART CONSTRUCTOR:
    public Cart(int cartId, ArrayList cartContent) {
        this.cartId = cartId;
        this.cartContent = cartContent;
    }

    // CART ID GETTER AND SETTER:
    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    // CART CONTENT LIST GETTER AND SETTER:
    public ArrayList getCartContent() {
        return cartContent;
    }

    public void setCartContent(ArrayList cartContent) {
        this.cartContent = cartContent;
    }
}
