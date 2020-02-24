package com.shop.ui;

import com.shop.exception.ShopException;
import com.shop.ui.handlers.InputPopUps;

import static com.shop.security.UserContext.isUserLogged;
import static com.shop.ui.handlers.InputPopUps.CANCELLED;

/**
 * MainUI class - directs user to LoginUI, signUpUI or shopUI.
 */

public class MainUI {

    private static final String OPTION_LOGIN = "1";
    private static final String OPTION_SIGN_UP = "2";

    private SignUpUI signUpUI = new SignUpUI();
    private LoginUI loginUI = new LoginUI();
    private ShopUI shopUI = new ShopUI();

    public void start() throws ShopException {
        String dataToShow = "";
        String userInput = "";
        do {
            if (isUserLogged()) {
                shopUI.start();
                dataToShow = "";
            } else {
                userInput = InputPopUps.input("Please choose an option by its number:\n\nLogin: 1\nSign Up: 2\n\n" + dataToShow);
                switch (userInput) {
                    case OPTION_LOGIN: {
                        loginUI.displayLogin();
                        break;
                    }
                    case OPTION_SIGN_UP: {
                        dataToShow = signUpUI.displaySignUp();
                        break;
                    }
                    case CANCELLED: {
                        break;
                    }
                    default: {
                        dataToShow = "Please enter a valid option:";
                    }
                }
            }
        }
        while (!userInput.equals(CANCELLED));
    }
}