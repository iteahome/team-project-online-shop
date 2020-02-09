package com.shop.dao;

import com.shop.exception.ShopException;
import com.shop.exception.ShopTechnicalException;
import com.shop.model.User;
import com.shop.service.UserService;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** UserDAO class - allows user database manipulation. */

public class UserDAO {

//  Method to identify all users in the database and store them as objects in an ArrayList:
    public List<User> findAllUsers() throws ShopTechnicalException {

//      Finding every individual user line (containing user fields' values) from the database:
        String userLine = FileEdit.read("users.txt","");
//      Finding every individual value of the user fields within the line:
        String[] userValues = userLine.split("\\|");

//      Creating a users ArrayList:
        List<User> userList = new ArrayList<>();
//      Adding the newly found users to this ArrayList:
        userList.add(new User(userValues[0], userValues[1], userValues[2], userValues[3]));

//      End result of the method - returning the users ArrayList:
        return userList;
    }

//  Method to add new users to the database:
    public static void AddUser(String newUserValues) throws ShopTechnicalException {
        FileEdit.write("users.txt", newUserValues);
    }

//  Method to modify user data in database (e.g.: change username, password or ):
//    public static void updateUser(User user) throws ShopTechnicalException {
//        // find user in database
//
//        Scanner keyboardScanner = new Scanner(System.in);
//        System.out.println("Confirm current email: ");
//        String inputEmail = keyboardScanner.nextLine();
//        System.out.println("Confirm current password: ");
//        String inputPassword = keyboardScanner.nextLine();
//
//        User updateUser (String inputEmail, String inputPassword) throws ShopException {
//            for (User user : UserDAO.FindAllUsers()) {
//                if (inputEmail.equals(user.getEmail()) && inputPassword.equals(user.getPassword())) {
//                    System.out.println("Log In Successful");
//                    return user;
//                }
//            }
//
//            String updatedUser = FileEdit.read("users.txt", currentUser);
//            // get user fields values as List via regex
//            // ask which field will be modified
//            // overwrite corresponding field via switch
//            // convert List to "modifiedUserData" String
//            // replace String in database:
//            FileEdit.write("users.txt", modifiedUserData);
//        }
//    }

//    public void deleteUser(User User) { /*TO BE DEVELOPED*/
//
//    }

}
