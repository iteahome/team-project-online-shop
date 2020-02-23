package com.shop.service;

import com.shop.model.Product;
import com.shop.security.CartContext;

import static com.shop.security.CartContext.cart;

public class CartService {
    public static void addToCart (Product product, Integer quantity){
        cart.put(product,quantity);
    }
}
