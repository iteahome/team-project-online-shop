package com.shop.ui;

import com.shop.exception.ProductNotFoundException;
import com.shop.exception.ShopFileException;
import com.shop.service.CartService;
import com.shop.service.ProductService;

public class CartUI {
    private  CartService cartService = new CartService();
    ProductService productService = new ProductService();

    public void useCart() throws ShopFileException, ProductNotFoundException {
        for (Integer id : cartService.showCart()) {
            productService.getProductByID(id);
        }
    }
}
