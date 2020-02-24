package com.shop.dao;

import com.shop.exception.ShopTechnicalException;
import com.shop.model.User;
import com.shop.model.Cart;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.io.File;

public class OrderDAO {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();
    FileEdit<Cart> fileEdit = new FileEdit<>();
    public void createOrder(Cart cart, User user) throws ShopTechnicalException {
        String filename = "orders/" + user.getEmail() + dtf.format(now) + ".txt";
        File file = new File("./src/main/resources/orders" + filename) ;
        fileEdit.write(filename, cart);
    }
}
