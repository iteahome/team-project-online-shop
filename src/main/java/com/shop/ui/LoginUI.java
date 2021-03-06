package com.shop.ui;

import com.shop.exception.ShopException;
import com.shop.exception.ShopWrongCredentialsException;
import com.shop.service.UserService;
import com.shop.ui.handlers.InputPopUps;

import static com.shop.ui.handlers.InputPopUps.CANCELLED;

/** LoginUI class - lets existing users login to online shop: */

class LoginUI {

    private UserService userService = new UserService();

    void displayLogin() throws ShopException {

        String email;
        String password;
        String dataToShow = "";
        do {
            email = InputPopUps.input("PLEASE ENTER YOUR EMAIL:\n\n" + dataToShow);
            password = InputPopUps.input("PLEASE ENTER YOUR PASSWORD:");
            if (!email.equals(CANCELLED) && !password.equals(CANCELLED)) {
                try {
                    userService.login(email, password);
                    break;
                } catch (ShopWrongCredentialsException e) {
                    dataToShow = "WRONG CREDENTIALS.";
                }
            }

        } while (!email.equals(CANCELLED) && !password.equals(CANCELLED));
    }
}