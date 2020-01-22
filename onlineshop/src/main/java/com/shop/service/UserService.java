package com.shop.service;

import com.shop.dao.UserDAO;
import com.shop.exception.ShopException;
import com.shop.exception.ShopWrongCredentialsException;
import com.shop.model.User;

public class UserService {
    private UserDAO userDAO = new UserDAO();

    public User login(String inputEmail, String inputPassword) throws ShopException {
        for (User user: userDAO.FindAllUsers()) {
            if (inputEmail.equals(user.getEmail()) && inputPassword.equals(user.getPassword())) {
                return user;
            }
        }
        throw new ShopWrongCredentialsException();
    }
}
