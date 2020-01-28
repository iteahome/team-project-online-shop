package com.shop.ui;
import com.shop.exception.ShopException;

import java.util.Scanner;

public class MainUI {

    private SignUpUi signUpUi = new SignUpUi();
    private LoginUi loginUi = new LoginUi();

    public void start() throws ShopException {
        System.out.println("Press 1 for Login and 2 for SignUp:_");
        Scanner scanner = new Scanner(System.in);
        int user_input = scanner.nextInt();
        if (user_input == 1) {
            loginUi.DisplayLogin();
        }
        if (user_input == 2) {
            signUpUi.DisplaySignUp();
        }
        else {
            System.out.println("Please insert a valid option.");
            start();
        }
    }
}
