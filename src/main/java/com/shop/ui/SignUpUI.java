package com.shop.ui;

import com.shop.ui.validator.EmailValidator;
import com.shop.ui.handlers.InputPopUps;
import com.shop.ui.handlers.PrintUI;
import com.shop.exception.ShopException;
import com.shop.service.UserService;

import static com.shop.ui.handlers.InputPopUps.CANCELLED;

/** SignUpUI class - creates new users by collecting user inputs. */

class SignUpUI {

    private EmailValidator emailValidator = new EmailValidator();
    private UserService userService = new UserService();

    void displaySignUp() throws ShopException {

        String email = InputPopUps.input("Please enter your email address:");
        String password = InputPopUps.input("Please enter desired password:");

        if (!email.matches(CANCELLED) && !password.matches(CANCELLED)) {
            if (emailValidator.isEmailValid(email)) {
                if (userService.doesUserExist(email)) {
                    PrintUI.printBox("User exists, please login.");
                } else {
                    userService.signUp(password, email);
                }
            } else {
                PrintUI.printBox("Please enter a valid email address:");
            }
        } else {
            PrintUI.printBox("User canceled operation.");
        }
    }
}