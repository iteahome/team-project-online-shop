package com.shop.security;

import com.shop.model.Product;
import java.util.HashMap;

public class CartContext {

    public static final HashMap<Product, Integer> cart = new HashMap<>();
}