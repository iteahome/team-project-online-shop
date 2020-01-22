package com.shop.ui;

import com.shop.exception.ShopException;
import com.shop.exception.ShopTechnicalException;
import com.shop.exception.ShopWrongCredentialsException;
import com.shop.service.UserService;

import java.util.Scanner;

class LoginUi {
    private UserService userService = new UserService();
    void DisplayLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert email: ");
        String email = scanner.nextLine();
        System.out.println("Insert Password: ");
        String password = scanner.nextLine();
        try {
            userService.login(email, password);
            System.out.println("User successfully login");
        } catch (ShopWrongCredentialsException e) {
            System.out.println("Wrong Credentials");
        } catch (ShopTechnicalException e) {
            e.printStackTrace();
            System.out.println("A system error appeared. Please contact your administrator");
        } catch (ShopException e) {
            e.printStackTrace();
        }
    }

}
