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

        String email;
        String password;
        do {
            email = InputPopUps.input("Please enter your email:");
            password = InputPopUps.input("Please enter your password:");
            if (!email.equals(CANCELLED) && !password.equals(CANCELLED)) {
                try {
                    userService.login(email, password);
                    break;
                } catch (ShopWrongCredentialsException e) {
                    PrintUI.printBox("Wrong credentials.");
                }
            }

        } while (!email.equals(CANCELLED) && !password.equals(CANCELLED));
    }
}