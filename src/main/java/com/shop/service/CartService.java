package com.shop.service;

import com.shop.model.Product;
import com.shop.ui.handlers.PrintUI;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.shop.security.CartContext.cart;

public class CartService {
    public void addToCart (Product product, Integer quantity){
        cart.put(product,quantity);
    }
    public List<Integer> showCart(){
        return new ArrayList<>(cart.values());
    }
}
