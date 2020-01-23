package com.shop.service;

import com.shop.dao.UserDAO;
import com.shop.exception.ShopException;
import com.shop.exception.ShopTechnicalException;
import com.shop.exception.ShopWrongCredentialsException;
import com.shop.model.User;

public class UserService {
    private UserDAO userDAO = new UserDAO();

    public User login(String inputEmail, String inputPassword) throws ShopException {
        for (User user : userDAO.FindAllUsers()) {
            if (inputEmail.equals(user.getEmail()) && inputPassword.equals(user.getPassword())) {
                System.out.println("Log In Successful");
                return user;
            }
        }
        throw new ShopWrongCredentialsException();
    }

    public String signup(String inputuserName, String inputPassword, String InputPhoneNo, String inputEmail) throws ShopTechnicalException {
        String userdata = inputuserName + "|" + inputPassword + "|" + InputPhoneNo + "|" + inputEmail;
        for (User user : userDAO.FindAllUsers()) {
            if (inputEmail.equals(user.getEmail()) ) {
                System.out.println("User already exists, please Login:_");
                break;
            } else {
                UserDAO.AddUser(userdata);
                System.out.println("User registered");
            }
        }  return userdata;
    }
}
