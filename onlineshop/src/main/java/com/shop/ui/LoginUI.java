package com.shop.ui;

import com.shop.exception.ShopException;
import com.shop.exception.ShopTechnicalException;
import com.shop.exception.ShopWrongCredentialsException;
import com.shop.service.UserService;

import java.util.Scanner;

/** LoginUI class - lets existing users login to online shop: */

class LoginUI {

    //  Initializing a UserService object for interacting with user database:
    private UserService userService = new UserService();

    //  Login UI starting point:
    void displayLogin() throws ShopException { /*EXCEPTION IS NEVER THROWN*/

//      Giving user instructions and waiting for their input:
        System.out.println("Please provide your credentials:\n");
        Scanner keyboardScanner = new Scanner(System.in);

//      Asking for registered email:
        System.out.println("Insert email: ");
        String email = keyboardScanner.nextLine();

//      Asking for registered password:
        System.out.println("Insert Password: ");
        String password = keyboardScanner.nextLine();

//      Checking the given data against the user database:

//      If login is successful:
        try {
            userService.login(email, password);
            System.out.println("Login successful."); /*AUTOMATICALLY TAKES USER TO SHOP?*/

//      If credentials are not found in database:
        } catch (ShopWrongCredentialsException e) {
            System.out.println(
                    "Wrong email and/or password. Please provide valid credentials.\n" +
                            "If you are a new user, please sign up first.");

//      If login fails for technical reasons:
        } catch (ShopTechnicalException e) {
            e.printStackTrace();
            System.out.println(
                    "A system error occured. We are sorry for the inconvenience." +
                            "Please try again later or contact us at +40 000 000 000. Thank you.");

//      If login fails for other reasons:
        } catch (ShopException e) {
            e.printStackTrace();
        }

    }
}