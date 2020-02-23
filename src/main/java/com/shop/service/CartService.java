package com.shop.service;

import com.shop.model.Product;

import java.util.ArrayList;
import java.util.List;

import static com.shop.security.CartContext.cart;

public class CartService {
    public void addToCart (Product product, Integer quantity){
        cart.put(product,quantity);
    }
    public ArrayList<Product> showKeys(){
        return new ArrayList<>(cart.keySet());
    }
    public List<Integer> showQuantity(Product product) {
        return new ArrayList<>(cart.get(product));
    }
}
