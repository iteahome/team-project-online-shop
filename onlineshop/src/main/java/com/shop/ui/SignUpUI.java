package com.shop.ui;

import com.shop.exception.ShopException;
import com.shop.exception.ShopTechnicalException;
import com.shop.service.UserService;

import java.util.Scanner;

/** SignUpUI class - creates new users via user input. */

public class SignUpUI {

//  Initializing a UserService object for interacting with user database:
    private UserService userService = new UserService();

//  SignUp UI starting point:
    void DisplaySignUp () throws ShopException { /*EXCEPTION IS NEVER THROWN*/

//      Giving user instructions and waiting for their input:
        System.out.println("To sign up, please fill in the following:\n");
        Scanner scanner = new Scanner(System.in);

//      Asking for desired username:
        System.out.println("Desired username: "); /*SHOULD BE ABLE TO CANCEL HERE*/
        String userName = scanner.nextLine();

//      Asking for desired password:
        System.out.println("Desired password: "); /*SHOULD BE ABLE TO CANCEL HERE*/
        String password = scanner.nextLine();

//      Asking for email:
        System.out.println("Your email address: "); /*SHOULD BE ABLE TO CANCEL HERE*/
        String email = scanner.nextLine();

//      Asking for phone number:
        System.out.println("Your phone number: "); /*SHOULD BE ABLE TO CANCEL HERE*/
        String phoneNo = scanner.nextLine();

//      Adding the given data to the user database: /*ERRORS OUT IF USER LIST IS EMPTY!*/
        try {
            userService.signUp(userName, password, email, phoneNo);
        } catch (ShopTechnicalException e) {
            e.printStackTrace();
        }

    }
}
