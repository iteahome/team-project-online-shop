package com.shop.ui;

import com.shop.ui.validator.EmailValidator;
import com.shop.ui.handlers.InputPopUps;
import com.shop.ui.handlers.PrintUI;
import com.shop.exception.ShopException;
import com.shop.service.UserService;

import static com.shop.ui.handlers.InputPopUps.CANCELLED;

/**
 * SignUpUI class - creates new users by collecting user inputs.
 */

class SignUpUI {

    private EmailValidator emailValidator = new EmailValidator();
    private UserService userService = new UserService();

    void displaySignUp() throws ShopException {

        String email;
        String password;
        do {
            email = InputPopUps.input("Please enter a valid email address:");
            password = InputPopUps.input("Please enter a valid password:");
            if (!email.matches(CANCELLED) && !password.matches(CANCELLED)) {
                if (emailValidator.isEmailValid(email) && !password.equals(".")) {
                    if (userService.doesUserExist(email)) {
                        PrintUI.printBox("User exists, please login.");
                        break;
                    } else {
                        userService.signUp(password, email);
                        break;
                    }
                } else {
                    PrintUI.printBox("Your email/password is invalid. Please retry.");
                }
            }
        } while (!email.equals(CANCELLED) && !password.equals(CANCELLED));

    }
}