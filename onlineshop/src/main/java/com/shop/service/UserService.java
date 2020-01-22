package com.shop.service;

import com.shop.dao.UserDAO;
import com.shop.exception.ShopException;
import com.shop.exception.ShopWrongCredentialsException;
import com.shop.exception.UserAlreadyExistsException;
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
    public String signup(String inputuserName, String inputPassword, String InputPhoneNo, String inputEmail) throws ShopException {
        String userdata = inputuserName + "|" + inputPassword + "|" + InputPhoneNo + "|" + inputEmail;
        for (User user: userDAO.FindAllUsers()) {
            if (!inputEmail.equals(user.getEmail())) {
                UserDAO.AddUser(userdata);
                return userdata;
            }
        }
        throw new UserAlreadyExistsException();

    }
}
