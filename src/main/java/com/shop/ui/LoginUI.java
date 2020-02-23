package com.shop.ui;

import com.shop.ui.handlers.InputPopUps;
import com.shop.ui.handlers.PrintUI;
import com.shop.exception.ShopException;
import com.shop.exception.ShopWrongCredentialsException;
import com.shop.service.UserService;

import static com.shop.ui.handlers.InputPopUps.CANCELLED;

/** LoginUI class - lets existing users login to online shop: */

class LoginUI {

    private UserService userService = new UserService();

    void displayLogin() throws ShopException {

        String email = InputPopUps.input("Please enter your email:");
        String password = InputPopUps.input("Please enter your password:");

        if (!email.equals(CANCELLED) && !password.equals(CANCELLED)) {
            try {
                userService.login(email, password);
            } catch (ShopWrongCredentialsException e) {
                PrintUI.printBox("Wrong credentials.");
            }
        } else {
            PrintUI.printBox("User canceled operation.");
        }
    }
}