package com.shop.ui;

import com.shop.exception.ShopException;

public class MainUI {
//    private LoginUi loginUi = new LoginUi();
//
//    public void start() {
//        loginUi.DisplayLogin();
//    }

    private SignUpUi signUpUi = new SignUpUi();
    public void start() throws ShopException {
        signUpUi.DisplaySignUp();
    }
}
