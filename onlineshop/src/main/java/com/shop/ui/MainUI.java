package com.shop.ui;

import com.shop.exception.ShopException;

import java.util.Scanner;

/** MainUI class - handles the initial contact with the user. */

public class MainUI {

//  Initializing objects of every UI type defined so far:
    private SignUpUI signUpUI = new SignUpUI();
    private LoginUI loginUI = new LoginUI();

//  Main UI starting point:
    public void start() throws ShopException {

//      Giving user instructions and waiting for their input:
        System.out.println(
            "Welcome to our online shop. \n" +
            "You can navigate menus by typing the action's number. \n\n" +
            "1. Login | 2. Sign Up | 3. Leave Shop");
        Scanner scanner = new Scanner(System.in);
        for (;;) {
            String userInput = scanner.nextLine();

//          Typing "1" sends user to Login menu:
            if (userInput.equals("1")) {
                loginUI.displayLogin();
                break;
            }

//          Typing "2" sends user to SignUp menu:
            if (userInput.equals("2")) {
                signUpUI.displaySignUp();
                break;
            }

//          Typing "3" ends the program:
            if (userInput.equals("3")) {
                break;
            }
            else {
                System.out.println("! Invalid input. Please type the action's number:");
            }
        }

    }
}