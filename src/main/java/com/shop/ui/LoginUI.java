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
    boolean displayLogin() throws ShopException {

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
            /** IF LOGIN FAILS, RETURN TO MainUI.start() */
            /** INSERT LINK TO USER TO SHOP HERE */
            return true;
//      If credentials are not found in database:
        } catch (ShopWrongCredentialsException e) {
//            System.out.println(
//                "\n..................................................\n" +
//                "Wrong email/password. Please choose an option:    \n" +
//                "..................................................\n");
//            MainUI mainUI = new MainUI();
//            mainUI.start();
            return false;
//      Managing possible exception:
        } catch (ShopException e) {
            System.out.println("Something wrong happened!");
            e.printStackTrace();
        } finally {
            keyboardScanner.close();
        }

        return false;
    }
}