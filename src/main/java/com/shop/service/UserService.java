package com.shop.service;

import com.shop.dao.UserDAO;
import com.shop.datahandlers.formatter.PrintUI;
import com.shop.exception.ShopException;
import com.shop.exception.ShopTechnicalException;
import com.shop.exception.ShopWrongCredentialsException;
import com.shop.model.User;
import com.shop.security.UserContext;

/** User Service class - allows login and sign up. */

public class UserService {
    private UserDAO userDAO = new UserDAO();

//     * Login method - checks given credentials against user database:
    public void login(String email, String password) throws ShopException {
        User userLogged = userDAO.findAllUsers().stream()
                .filter(user -> areCredentialsEqual(email, password, user))
                .findFirst().orElseThrow(ShopWrongCredentialsException::new);
        UserContext.setLoggedUser(userLogged);
    }

    private boolean areCredentialsEqual(String email, String password, User user) {
        return email.equals(user.getEmail()) && password.equals(user.getPassword());
    }


/** SignUp method - tries to add given credentials to the user database: */
    public void signUp(String password, String email) throws ShopTechnicalException {
        boolean userExists = userDAO.findAllUsers().stream()
                .anyMatch(user -> email.equals(user.getEmail()));

        if (!userExists) {
            User user = new User(password, email, "Shopper");
            UserDAO.addUser(user.DBprint());
        }
        else {
            PrintUI.printBox("User Exists, Please Login.");
        }
    }
}