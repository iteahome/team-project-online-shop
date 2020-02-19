package com.shop.ui;

import com.shop.datahandlers.formatter.InputPopUps;
import com.shop.datahandlers.formatter.PrintUI;
import com.shop.exception.ShopException;
import com.shop.exception.ShopWrongCredentialsException;
import com.shop.service.UserService;

import java.util.Scanner;

/** LoginUI class - lets existing users login to online shop: */

class LoginUI {

    //  Initializing a UserService object for interacting with user database:
    private UserService userService = new UserService();

    //  Login UI starting point:
    boolean displayLogin() throws ShopException {
        PrintUI.printBox("Please provide your Login Credentials: ");
        String email = InputPopUps.input("Email:");
        String password = InputPopUps.input("Password:");

        try {
            userService.login(email, password);
            PrintUI.printBox("Login Successful");
            return true;
        } catch (ShopWrongCredentialsException e) {
            PrintUI.printBox("Wrong credentials.");
        }
        return true;
    }
}