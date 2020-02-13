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
        System.out.println("Please provide valid credentials:\n");
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
            /** INSERT LINK TO USER TO SHOP HERE */

//      If credentials are not found in database:
        } catch (ShopWrongCredentialsException e) {
//          Giving user options to continue:
            System.out.println(
                "User not found. Please choose an option:\n" +
                "1. Retry Login | 2. Sign Up | 3. Leave Shop");
            for (;;) {
                String userInput = keyboardScanner.nextLine();
//              Retrying login:
                if (userInput.equals("1")) {
                    displayLogin();
                    break;
                }
//              Going directly to signUp:
                if (userInput.equals("2")) {
                    System.out.println("! LINK TO SIGNUP FROM LOGIN NOT DEVELOPED YET. EXITING.");
                    /** INSERT LINK TO SIGNUP HERE */
                    break;
                }
//              Closing the program:
                if (userInput.equals("3")) {
                    break;
                }
//              If input invalid:
                else {
                    System.out.println("Invalid input. Please type a valid action number:");
                }
            }

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