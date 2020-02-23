package com.shop.service;

import com.shop.exception.ProductNotFoundException;
import com.shop.exception.ShopFileException;
import com.shop.model.Product;

import java.util.ArrayList;
import java.util.List;

import static com.shop.security.CartContext.cart;

public class CartService {

    ProductService productService = new ProductService();

    public void addToCart (Product product, Integer quantity){
        cart.put(product,quantity);
    }
    public ArrayList<Product> showKeys(){
        return new ArrayList<>(cart.keySet());
    }
    public Integer showQuantity(Product product) {
        return cart.getOrDefault(product, 0);
    }
    public void editQuantity (Integer id, Integer quantity) throws ShopFileException, ProductNotFoundException {
        cart.replace(productService.getProductByID(id), quantity);
    }
    public void deleteProduct (Integer id) throws ShopFileException, ProductNotFoundException {
        cart.remove(productService.getProductByID(id));
    }
}
