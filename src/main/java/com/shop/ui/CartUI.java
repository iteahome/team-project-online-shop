package com.shop.ui;

import com.shop.exception.ProductNotFoundException;
import com.shop.exception.ShopFileException;
import com.shop.model.Product;
import com.shop.service.CartService;
import com.shop.service.ProductService;
import com.shop.ui.handlers.PrintUI;

public class CartUI {
    private  CartService cartService = new CartService();
    ProductService productService = new ProductService();

    public void viewCart() throws ShopFileException, ProductNotFoundException {
        for (Product product : cartService.showKeys()) {
            PrintUI.printBox(product.toString() + cartService.showQuantity(product));
        }
    }
}
