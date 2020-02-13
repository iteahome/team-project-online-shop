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
    void displaySignUp() throws ShopException { /*EXCEPTION IS NEVER THROWN*/

//      Giving user instructions and waiting for their input:
        System.out.println("To sign up, please fill in the following:\n");
        Scanner scanner = new Scanner(System.in);

//      Asking for desired username:
        System.out.println("Desired username: (type \"0\" or leave empty to cancel)");
//        String userInput = scanner.nextLine();
        String userName = null;
        while (!(userName = scanner.nextLine()).isEmpty())


        if (!userInput.isEmpty()) {


            if (userInput.equals("0")) {
                System.out.println("LINK TO MAIN MENU NOT YET DEVELOPED");
                /** INSERT CODE HERE TO RETURN TO MainUI MENU */
            } else {
                userName = userInput;
            }
        }

//      Asking for desired password:
        System.out.println("Desired password: ");
        /** SHOULD BE ABLE TO CANCEL HERE (IF USER SUDDENLY REMEMBERS CREDENTIALS)*/
        String password = scanner.nextLine();

//      Asking for email:
        System.out.println("Your email address: ");
        /** SHOULD BE ABLE TO CANCEL HERE (IF USER SUDDENLY REMEMBERS CREDENTIALS)*/
        /** EMAIL IS THE IDENTIFIER: INSERT CODE HERE TO VERIFY EMAIL IN A LOOP HERE UNTIL VALID. OTHERWISE, USER HAS TO INPUT ALL THE DETAILS EVERY TIME... */
        String email = scanner.nextLine();

//      Asking for phone number:
        System.out.println("Your phone number: ");
        /** SHOULD BE ABLE TO CANCEL HERE (IF USER SUDDENLY REMEMBERS CREDENTIALS)*/
        String phoneNo = scanner.nextLine();

//      Adding the given data to the user database: /**ERRORS OUT IF USER LIST IS EMPTY!*/
        try {
            userService.signUp(userName, password, email, phoneNo);
        } catch (ShopTechnicalException e) {
            e.printStackTrace();
        }

    }
}