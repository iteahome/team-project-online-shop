package com.shop;

import com.shop.exception.ShopException;
import com.shop.ui.MainUI;

/** OnlineShop class - the program entry point. */

public class OnlineShop {

    public static void main (String[] args) throws ShopException {
        new MainUI().start();
    }
}
