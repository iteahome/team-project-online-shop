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

/** Login method - checks given credentials against user database: */
    public User login(String email, String password) throws ShopException {

//      Checking the provided email and password, user by user:
        for (User user : userDAO.findAllUsers()) {
            if (email.equals(user.getEmail()) && password.equals(user.getPassword())) {
                System.out.println("Login successful. Happy shopping!");
                return user;
            }
        }

//      If no user is found using provided credentials:
        throw new ShopWrongCredentialsException();
    }

/** Signup method - adds given credentials to the user database: */
    public boolean signUp(String userName, String password, String email, String phoneNo) throws ShopTechnicalException {

//      Setting a flag to confirm successful signup:
        boolean signedUp = false;

//      Concatenating inputs sequentially into a new String, separated by "|":
        String userData = userName + "|" + password + "|" + email + "|" + phoneNo;

//      If database is empty, add user directly:
        if (userDAO.findAllUsers().isEmpty()) {
            UserDAO.addUser(userData);
            signedUp = true;
            System.out.println("Congratulations! You are our first registered user. Logging in with you new credentials...");
            /** INSERT LINK TO SHOP HERE */
        }

//      Checking if user already exists:
        boolean userExists = false;
//      If email is already used in database:
        for (User user : userDAO.findAllUsers()) {
            if (email.equals(user.getEmail())) {
                userExists = true;
                System.out.println("A user with this email already exists.");
                break;
            }
        }
//      If email is not yet used, add user to database:
        if (!userExists) {
            UserDAO.addUser(userData);
            signedUp = true;
            System.out.println("User successfully registered. Logging in with you new credentials...");
            /** INSERT LINK TO LOGIN HERE */
        }
        return signedUp;

    }
}