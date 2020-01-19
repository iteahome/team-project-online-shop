package com.shop.dao;

import com.shop.model.User;

public class userimp {

    public static void findAll() {
        fileedit.read("test.txt","");
    }

    public static void findById() {
        System.out.println("findbyid");
    }

    public static void findbyname (String name) {
        fileedit.read("test.txt", String.format("^.*%s.*?\r\n", name));
    }

    public static void insertUser() {
        fileedit.write("user.txt", User.getDatas());

    }

    public void updateUser(User User) {

    }

    public void deleteUser(User User) {

    }
}
