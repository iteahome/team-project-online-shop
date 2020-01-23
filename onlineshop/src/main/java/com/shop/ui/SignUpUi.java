package com.shop.ui;

import com.shop.exception.ShopException;
import com.shop.exception.ShopTechnicalException;
import com.shop.service.UserService;

import java.util.Scanner;

public class SignUpUi {
    private UserService userService = new UserService();
    void DisplaySignUp () throws ShopException {
        System.out.println("To sign up, please fill the following details: ");
        Scanner scanner = new Scanner(System.in);
        System.out.println("UserName: ");
        String UserName = scanner.nextLine();
        System.out.println("Password: ");
        String password = scanner.nextLine();
        System.out.println("PhoneNo as '07xxxxxxxx': ");
        String phoneNo = scanner.nextLine();
        System.out.println("Email: ");
        String email = scanner.nextLine();
        try {
            userService.signup(UserName, password, phoneNo, email);
        } catch (ShopTechnicalException e) {
            e.printStackTrace();
        }
    }
}
