package com.shop;

import com.shop.dao.UserDAO;
import com.shop.model.User;

public class onlineshop {

    public static void main (String[] args) {
        System.out.println("WELCOME");
//        userimp.insertUser();
//        userimp.findAll();
        UserDAO.findbyname("hello world");

    }
}

