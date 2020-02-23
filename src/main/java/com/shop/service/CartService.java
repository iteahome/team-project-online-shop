package com.shop.service;

import com.shop.model.Product;
import com.shop.ui.handlers.PrintUI;

import static com.shop.security.CartContext.cart;

public class CartService {
    public static void addToCart (Product product, Integer quantity){
        cart.put(product,quantity);
    }
    public static void showCart () {
        PrintUI.printBox(cart.values().toString());
    }
}
