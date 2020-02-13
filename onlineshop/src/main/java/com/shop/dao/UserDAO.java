package com.shop.dao;

import com.shop.exception.ShopTechnicalException;
import com.shop.model.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** UserDAO class - allows user database manipulation. */

public class UserDAO {

/** Method to identify all users in the database and store them as objects in an ArrayList: */
    public List<User> findAllUsers() throws ShopTechnicalException {

//      Building a List of user data Strings from the users database:
        List<String> userDataList = new ArrayList<>();
        try {
//          Pointing to the user database file:
            File users = new File("./src/main/resources/users.txt");
//          Scanning the database line by line and adding those lines to the user data List:
            Scanner userScanner = new Scanner(users);
            while (userScanner.hasNextLine()) {
                userDataList.add(userScanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

//      Converting the List of user data Strings into a List of User objects:
        List<User> userList = new ArrayList<>();
        for (String userData : userDataList) {
            String[] userDataValues = userData.split("\\|");
            userList.add(new User(userDataValues[0], userDataValues[1], userDataValues[2], userDataValues[3]));
        }

//      End result of the method - returning the User object ArrayList:
        return userList;
    }

/** Method to add new users to the database: */
    public static void addUser(String newUserValues) throws ShopTechnicalException {

//      Adding given values to end of the database:
        FileEdit.write("users.txt", newUserValues);
    }

///** Method to modify current user's values in the database: */
///* @team: WILL ACTUAL USER OBJECTS BE STORED IN "SECURITY", OR...? THIS METHOD RELIES ON THE ABILITY TO IDENTIFY KNOWN USER OBJECTS */
//    public static void updateUser(User currentUser, String userInput, String newValue) throws ShopTechnicalException {
//
////  Setting new user object value according to the user's input:
//    switch (userInput) {
//        case "userName":
//            currentUser.setUserName(newValue);
//            break;
//        case "password":
//            currentUser.setPassword(newValue);
//            break;
//        case "email":
//           currentUser.setEmail(newValue);
//            break;
//        case "phoneNo":
//            currentUser.setPhoneNo(newValue);
//            break;
//        default:
//            System.out.println("Invalid property. Valid properties: userName, password, email, phoneNo.");
//    }
//
////  Identifying old and new value lines:
///* @team: I AM CONSIDERING EMAIL AS THE UNIQUE IDENTIFIER IN THE DATABASE. PLEASE CONFIRM */
//    String currentUserValues = FileEdit.read("users.txt", currentUser.getEmail());
//    String newUserValues = currentUser.getUserName() + "|" + currentUser.getPassword() + "|" + currentUser.getEmail() + "|" + currentUser.getPhoneNo();
//
////  Switching the 2 value sets:
///* @team: WE NEED A FileEdit.replace() METHOD. FileEdit.write() WRITES AT THE END AND ADDS A NEW LINE, WHICH IS NOT WHAT WE NEED HERE. */
//    }
//
//    public static void replaceTest(String muhaha)  throws ShopTechnicalException {
//        FileEdit.replace("replaceTestFile", "", muhaha);
//    }
//
///** Method to delete current user's values from the database: */
//    public void deleteUser(User user) {
//
////  Removing user line from the database:
////    FileEdit.delete(user);
///* @team: WE NEED A FileEdit.delete() METHOD. */
//    }

}
