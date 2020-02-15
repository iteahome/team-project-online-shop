package com.shop.ui;

import com.shop.exception.ShopException;
import com.shop.exception.ShopWrongCredentialsException;
import com.shop.service.UserService;

import java.util.Scanner;

/** LoginUI class - lets existing users login to online shop: */

class LoginUI {

//  Initializing a UserService object for interacting with user database:
    private UserService userService = new UserService();

//  Login UI starting point:
    void displayLogin() throws ShopException {

//      Giving user instructions and waiting for their input:
        System.out.println(
            "\n.................................................." +
            "\nPlease provide valid credentials:                 " +
            "\n..................................................\n");
        Scanner keyboardScanner = new Scanner(System.in);

//      Asking for registered email:
        System.out.println("Enter email: ");
        String email = keyboardScanner.nextLine();

//      Asking for registered password:
        System.out.println("Enter password: ");
        String password = keyboardScanner.nextLine();

//      Checking the given data against the user database:

//      If login is successful:
        try {
            userService.login(email, password);
            /** INSERT LINK TO USER TO SHOP HERE */

//      Managing possible exception:
        } catch (ShopWrongCredentialsException e) {
//          Giving user options to continue:
            System.out.println(
                "\nInvalid email/password. Please choose an option:          " +
                "\n__________________________________________________" +
                "\n1. Retry Login | 2. Sign Up | 3. Leave Shop       " +
                "\n__________________________________________________\n");
            for (;;) {
                String userInput = keyboardScanner.nextLine();
//              Retrying login:
                if (userInput.equals("1")) {
                    displayLogin();
                    break;
                }
//              Going directly to sign up:
                if (userInput.equals("2")) {
                    SignUpUI signUpUI = new SignUpUI();
                    signUpUI.displaySignUp();
                    break;
                }
//              Closing the program:
                if (userInput.equals("3")) {
                    System.out.println(
                        "\n__________________________________________________" +
                        "\nCome back soon!                                   " +
                        "\n__________________________________________________\n");
                    break;
                }
//              If input invalid:
                else {
                    System.out.println("\nInvalid input. Please type a valid action number:");
                }
            }

//      Managing possible exception:
        } catch (ShopException e) {
            e.printStackTrace();
        }

        keyboardScanner.close();

    }
}