package com.shop.ui;
import com.shop.exception.ShopException;

import java.util.Scanner;


public class MainUI {

    private SignUpUi signUpUi = new SignUpUi();
    private LoginUi loginUi = new LoginUi();

    public void start() throws ShopException {
        System.out.println("Press 0 to exit, 1 for Login, and 2 for SignUp:_");
        Scanner scanner = new Scanner(System.in);
        for (;;) {
            String user_input = scanner.nextLine();
            if (user_input.equals("1")) {
                loginUi.DisplayLogin();
                break;
            }
            if (user_input.equals("2")) {
                signUpUi.DisplaySignUp();
                break;
            }
            if (user_input.equals("0")) {
                break;
            }
            else {
                System.out.println("Please insert a valid option:_");
            }
        }
    }
}
