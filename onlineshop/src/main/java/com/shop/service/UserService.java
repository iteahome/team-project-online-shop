package com.shop.service;

import com.shop.dao.UserDAO;
import com.shop.exception.ShopException;
import com.shop.exception.ShopTechnicalException;
import com.shop.exception.ShopWrongCredentialsException;
import com.shop.model.User;

/** User Service class - allows login and sign up. */

public class UserService {

//  Instancing a UserDAO object - provides methods to manipulate user database:
    private UserDAO userDAO = new UserDAO();

//  Login method - checks given credentials against user database:
    public User login(String inputEmail, String inputPassword) throws ShopException {

//      Checking the provided email and password, user by user:
        for (User user : userDAO.FindAllUsers()) {
            if (inputEmail.equals(user.getEmail()) && inputPassword.equals(user.getPassword())) {
                System.out.println("Log In Successful");
                return user;
            }
        }

//      If no user is found using provided credentials:
        throw new ShopWrongCredentialsException();
    }

//  Signup method - adds given credentials to the user database:
    public String signUp(String inputUserName, String inputPassword, String inputEmail, String inputPhoneNo) throws ShopTechnicalException {

//      Concatenating inputs sequentially into a new String, separated by "|":
        String userData = inputUserName + "|" + inputPassword + "|" + inputEmail + "|" + inputPhoneNo;

//      Checking if user already exists:
        for (User user : userDAO.FindAllUsers()) {

//          If email already exists:
            if (inputEmail.equals(user.getEmail())) {
                System.out.println(
                    "A user with this email already exists. \n" +
                    "Please provide a different email address."); /*SHOULD ALSO GIVE ME THE OPTION TO GO DIRECTLY TO LOGIN*/
                break;

//          If input is valid, it is added to the user database:
            } else {
                UserDAO.AddUser(userData);
                System.out.println(
                    "User successfully registered.\n" +
                    "Please use your new credentials to LogIn."); /*OR MAYBE AFTER REGISTERING WE COULD AUTOMATICALLY LOG THEM IN*/
            }
        }

//      End result of signUp method - returning a String:
        return userData;

    }
}
