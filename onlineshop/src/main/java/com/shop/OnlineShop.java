package com.shop;

import com.shop.exception.ShopException;
import com.shop.ui.MainUI;

/** OnlineShop class - the program entry point. */

public class OnlineShop {

    public static void main (String[] args) throws ShopException {
        System.out.println(
            "______________________________________________\n" +
            "Welcome to our online shop!\n" +
            "You can navigate menus by typing their number.\n" +
            "______________________________________________\n");
        MainUI mainUI = new MainUI();
        mainUI.start();
    }
}