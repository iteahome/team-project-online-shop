package com.shop.service;

import com.shop.dao.UserDAO;
import com.shop.exception.ShopException;
import com.shop.exception.ShopTechnicalException;
import com.shop.exception.ShopWrongCredentialsException;
import com.shop.model.User;
import com.shop.security.UserContext;

/** User Service class - allows login and sign up. */

@Service
public class UserService {

//  Instancing a UserDAO object - provides methods to manipulate user database:
    @Autowired
    private UserDAO userDAO;
//    private UserDAO userDAO = new UserDAO();

/** Login method - checks given credentials against user database: */
    public void login(String email, String password) throws ShopException {

//      Checking the provided email and password, user by user:
        User userLogged = userDAO.findAllUsers().stream()
                .filter(user -> areCredentialsEquals(email, password, user))
                .findFirst().orElseThrow(ShopWrongCredentialsException::new);

        UserContext.setLoggedUser(userLogged);

        System.out.println(
                "\n__________________________________________________" +
                        "\nLogin successful. Happy shopping!                 " +
                        "\n__________________________________________________\n");
    }

    private boolean areCredentialsEquals(String email, String password, User user) {
        return email.equals(user.getEmail()) && password.equals(user.getPassword());
    }

    /** SignUp method - tries to add given credentials to the user database: */
    public boolean signUp(String userName, String password, String email, String phoneNo) throws ShopTechnicalException {

//      Setting a flag to confirm successful sign up:
        boolean signedUp = false;

//      Concatenating inputs sequentially into a new String, separated by "|":

        String userData = userName + "|" + password + "|" + email + "|" + phoneNo;

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);

//      If database is empty, add first user directly:
//        if (userDAO.findAllUsers().isEmpty()) {
//            UserDAO.addUser(userData);
//            signedUp = true;
//            System.out.println(
//                "\n.................................................." +
//                "\nCongratulations, you are now our first shopper!   " +
//                "\nLogging in with you new credentials...            " +
//                "\n..................................................");
////          Automatically log first new user in:
//            try {
//                login(email, password);
//            } catch (ShopException e) {
//                e.printStackTrace();
//            }
//        }

        userDAO.findAllUsers().stream()
                .filter(user -> email.equals(user.getEmail()))
                .findAny()
                    .map(this::showUserExists)
                    .orElseGet(()-> UserDAO.addUser(userData));

//      Checking if user already exists - starting by initializing a flag:
        boolean userExists = false;
//      If this wasn't the first added user:
        if (!signedUp) {
//      Checking the database for the user using their email:
            for (User user : userDAO.findAllUsers()) {
                if (email.equals(user.getEmail())) {
                    userExists = true;
                    System.out.println(
                        "\n.................................................." +
                        "\nA user with this email already exists.            " +
                        "\n.................................................." +
                        "\n");
                    break;
                }
            }
        }


//      If this wasn't the first added user and the email has not been used, add user to database:
        if (!signedUp & !userExists) {
            UserDAO.addUser(userData);
            signedUp = true;
            System.out.println(
                "\n.................................................." +
                "\nUser successfully registered.                     " +
                "\nLogging in with you new credentials...            " +
                "\n..................................................");
//          Automatically log new user in:
            try {
                login(email, password);
            } catch (ShopException e) {
                e.printStackTrace();
            }
        }

//      Method's end result - confirmation of a successful/failed sign up:
        return signedUp;

    }

    private User showUserExists(User user) {
        System.out.println(
                "\n.................................................." +
                        "\nA user with this email already exists.            " +
                        "\n.................................................." +
                        "\n");

        return user;
    }
}