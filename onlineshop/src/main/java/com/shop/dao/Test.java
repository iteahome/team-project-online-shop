package com.shop.dao;

import com.shop.dao.FileEdit;

/** OnlineShop class - the program entry point. */

public class Test {

    public static void main (String[] args) {

        FileEdit.replace("users.txt", "email2", "password2", "passkey2");

    }
}