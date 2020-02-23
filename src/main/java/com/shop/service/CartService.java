package com.shop.service;

import com.shop.dao.OrderDAO;
import com.shop.exception.ShopTechnicalException;
import com.shop.model.Cart;
import com.shop.model.Product;
import com.shop.security.UserContext;
import com.shop.ui.handlers.PrintUI;

import java.util.ArrayList;

import static com.shop.model.Cart.cart;

public class CartService {

    ProductService productService = new ProductService();
    OrderDAO orderDAO = new OrderDAO();
    public boolean isCartNull = cart.isEmpty();

    public void addToCart (Product product, Integer quantity){
        cart.put(product,quantity);
    }
    public ArrayList<Product> showKeys(){
        return new ArrayList<>(cart.keySet());
    }
    public Integer showQuantity(Product product) {
        return cart.getOrDefault(product, 0);
    }
    public void editQuantity (Integer id, Integer quantity) {
        cart.replace(productService.getProductByID(id), quantity);
    }
    public void deleteProduct (Integer id) {
        cart.remove(productService.getProductByID(id));
    }
    public void createOrder () throws ShopTechnicalException {
        orderDAO.createOrder(cart.get(), UserContext.getLoggedUser());
        PrintUI.printBox("Order Sent.");
        cart.clear();
    }
}
