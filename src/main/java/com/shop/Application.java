package com.shop;

import com.shop.exception.ShopException;
import com.shop.ui.MainUI;

/** OnlineShop class - the program entry point. */

public class Application {
    public static void main(String[] args) throws ShopException {
            MainUI mainUI = new MainUI();
            mainUI.start();
    }
}