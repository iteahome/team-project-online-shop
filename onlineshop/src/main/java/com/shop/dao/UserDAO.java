package com.shop.dao;

import com.shop.exception.ShopTechnicalException;
import com.shop.model.User;
import com.sun.tools.jdeprscan.scan.Scan;

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
    public static void addUser(String newUserValues) throws ShopTechnicalException {
        FileEdit.write("users.txt", newUserValues);
    }

    public static void updateUser(User user) throws ShopTechnicalException { /* UPDATE USER UI NEEDED */

        /* Find user by asking for credentials confirmation. */

        System.out.println("Please confirm your current email address:");
        String email = new Scanner(System.in).next();
        System.out.println("Please confirm your current password:");
        String password = new Scanner(System.in).next();

        /* Use given credentials to find user in database. */

        String userLine = FileEdit.read("users.txt", email);

        /* Get new values from keyboard. */
        /* Overwrite user with newly given values */
    }

//    public void deleteUser(User User) { /*TO BE DEVELOPED*/
//
//    }

}
