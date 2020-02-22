package com.shop.ui;

import com.shop.ui.validator.EmailValidator;
import com.shop.ui.handlers.InputPopUps;
import com.shop.ui.handlers.PrintUI;
import com.shop.exception.ShopException;
import com.shop.service.UserService;

import static com.shop.ui.handlers.InputPopUps.CANCELLED;

/** SignUpUI class - creates new users by collecting user inputs. */

class SignUpUI {

    private UserService userService = new UserService();
    private EmailValidator emailValidator = new EmailValidator();

    void displaySignUp() throws ShopException {

        String inputEmail = InputPopUps.input("Please enter your email address:");
        String inputPassword = InputPopUps.input("Please enter desired password:");

        if (!inputEmail.matches(CANCELLED) && !inputPassword.matches(CANCELLED)) {
            if (emailValidator.validateEmail(inputEmail)) {
                if (userService.signUp(inputPassword, inputEmail)) {
                    PrintUI.printBox("User exists, please login.");
                } else {
                    PrintUI.printBox("Welcome! You are now logged in with your new credentials.");
                }
            } else {
                PrintUI.printBox("Please enter a valid email address:");
            }
        }
        else {
            PrintUI.printBox("User canceled operation.");
        }
    }
}