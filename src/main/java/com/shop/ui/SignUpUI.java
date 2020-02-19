package com.shop.ui;

import com.shop.datahandlers.formatter.InputPopUps;
import com.shop.datahandlers.formatter.PrintUI;
import com.shop.exception.ShopException;
import com.shop.service.UserService;

/** SignUpUI class - creates new users by collecting user inputs. */

class SignUpUI {

    private UserService userService = new UserService();

    //  SignUp UI starting point:
    void displaySignUp() throws ShopException {
        PrintUI.printBox("To sign up, please provide the following credentials:");
        String inputEmail = InputPopUps.input("Email:");
        String inputPassword = InputPopUps.input("New Password");
        userService.signUp(inputPassword, inputEmail);
    }
}