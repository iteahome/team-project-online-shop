package com.shop.dao;

import com.shop.model.User;

import java.util.List;

public class userimp {

    public static void findAll() {
        fileedit.find("test.txt","1");
    }

    public static void findById() {
        System.out.println("findbyid");
    }

    public static void findbyname() {
        System.out.println("findbyname");
    }

    public static void insertUser() {
        fileedit.write("user.txt", "hello worlf");

    }

    public void updateUser(User User) {

    }

    public void deleteUser(User User) {

    }
}
