package com.shop.dao;

        import com.shop.dao.FileEdit;

/** OnlineShop class - the program entry point. */

public class Test {

    public static void main (String[] args) {

        System.out.println("findLine found: " + FileEdit.findLine("test_users.txt", "email2|"));
        FileEdit.replace("test_users.txt", "email2", "password2", "passkey2");

    }
}