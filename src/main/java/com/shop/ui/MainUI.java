package com.shop.ui;

import com.shop.ui.handlers.InputPopUps;
import com.shop.ui.handlers.PrintUI;
import com.shop.exception.ShopException;

import static com.shop.security.UserContext.isUserLogged;
import static com.shop.ui.handlers.InputPopUps.CANCELLED;

/** MainUI class - directs user to LoginUI, signUpUI or shopUI. */

public class MainUI {

    private static final String OPTION_LOGIN = "1";
    private static final String OPTION_SIGN_UP = "2";
    private static final String OPTION_LEAVE = "0";

    private SignUpUI signUpUI = new SignUpUI();
    private LoginUI loginUI = new LoginUI();
    private ShopUI shopUI = new ShopUI();

    public void start() throws ShopException {
        String userInput;
        do {
            userInput = InputPopUps.input("Please choose an option by its number:\n\nLogin: 1\nSign Up: 2\nLeave Shop: 0");
            switch (userInput) {
                case OPTION_LOGIN: {
                    loginUI.displayLogin();
                    if (isUserLogged()) {
                        shopUI.start();
                    }
                    break;
                }
                case OPTION_SIGN_UP: {
                    signUpUI.displaySignUp();
                    break;
                }
                case OPTION_LEAVE: {
                    PrintUI.printBox("Come back soon!");
                    break;
                }
                case CANCELLED: {
                    PrintUI.printBox("User canceled operation.");
                    break;
                }
                default: {
                    PrintUI.printBox("Please enter a valid option:");
                }
            }
        } while (!userInput.equals(OPTION_LEAVE) && !isUserLogged());
    }
}