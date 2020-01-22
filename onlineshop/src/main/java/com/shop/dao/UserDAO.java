package com.shop.dao;

import com.shop.model.User;

public class UserDAO {

    public static void findAll() {
        fileedit.read("test.txt","");
    }

    public static void findById() {
        System.out.println("findbyid");
    }

    public static void findbyname (String name) {
        String universregex = ".*" + name + ".*";
        fileedit.read("test.txt", universregex);
    }

    public static void insertUser() {

    }

    public void updateUser(User User) {

    }

    public void deleteUser(User User) {

    }
}
