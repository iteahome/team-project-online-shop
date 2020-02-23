package com.shop.ui;

import com.shop.exception.ShopException;
import com.shop.model.User;
import com.shop.service.UserService;
import com.shop.ui.handlers.InputPopUps;
import com.shop.ui.handlers.PrintUI;
import com.shop.ui.validator.PhoneNoValidator;

import static com.shop.ui.handlers.InputPopUps.CANCELLED;

/** UserAccountUI class - connects user input to UserService class to manage account data. */

public class UserAccountUI {

    final String VIEW_ACCOUNT = "1";
    final String MODIFY_ACCOUNT = "2";
    final String GO_BACK = "0";

    final String CHANGE_USERNAME = "1";
    final String CHANGE_PASSWORD = "2";
    final String CHANGE_PHONENO = "3";

    UserService userService = new UserService();
    PhoneNoValidator phoneNoValidator = new PhoneNoValidator();

    void manageAccount(User user) {
        String userInput;
        do {
            userInput = InputPopUps.input("User account menu:\n\nView account: 1\nModify account: 2\nGo Back: 0");
            switch (userInput) {
                case VIEW_ACCOUNT:
                    PrintUI.printBox(user.printCompleteUserData());
                    break;
                case MODIFY_ACCOUNT:
                    modifyAccount(user);
                    break;
                case GO_BACK:
                    break;
                case CANCELLED:
                    PrintUI.printBox("User canceled operation.");
                    break;
                default:
                    PrintUI.printBox("Please enter a valid option:");
            }
        } while (!userInput.equals(GO_BACK));
    }

    private void modifyAccount(User user) {
        String dataToChange;
        do {
            dataToChange = InputPopUps.input("Modify account menu:\n\nChange username: 1\nChange password: 2\nChange phone number: 3\nGo Back: 0");
            switch (dataToChange) {
                case CHANGE_USERNAME:
                    changeUserName(user);
                    break;
                case CHANGE_PASSWORD:
                    changePassword(user);
                    break;
                case CHANGE_PHONENO:
                    changePhoneNo(user);
                    break;
                case GO_BACK:
                    break;
                case CANCELLED:
                    PrintUI.printBox("User canceled operation.");
                    break;
                default:
                    PrintUI.printBox("Please enter a valid option:");
            }
        } while (!dataToChange.equals(GO_BACK));
    }

    private void changeUserName(User user) {
        String newUserName = InputPopUps.input("Enter new username:");
        while (!newUserName.equals(CANCELLED)) {
            if (newUserName.equals(".")) {
                newUserName = InputPopUps.input("Please enter a valid option:");
            } else {
                user.setUserName(newUserName);
                try {
                    userService.replaceUserData(user);
                } catch (ShopException e) {
                    e.printStackTrace();
                }
            }
        }
        PrintUI.printBox("User canceled operation.");
    }

    private void changePassword(User user) {
        String newPassword = InputPopUps.input("Enter new password:");
        while (!newPassword.equals(CANCELLED)) {
            if (newPassword.equals(".")) {
                newPassword = InputPopUps.input("Please enter a valid option:");
            } else {
                user.setUserName(newPassword);
                try {
                    userService.replaceUserData(user);
                } catch (ShopException e) {
                    e.printStackTrace();
                }
            }
        }
        PrintUI.printBox("User canceled operation.");
    }

    private void changePhoneNo(User user) {
        String newPhoneNo = InputPopUps.input("Enter new Romanian phone number:");
        while (!newPhoneNo.equals(CANCELLED)) {
            if (!phoneNoValidator.isPhoneNoValid(newPhoneNo)) {
                newPhoneNo = InputPopUps.input("Invalid number. Please try again:");
            } else {
                user.setPhoneNo(phoneNoValidator.formatPhoneNo(newPhoneNo));
                try {
                    userService.replaceUserData(user);
                } catch (ShopException e) {
                    e.printStackTrace();
                }
            }
        }
        PrintUI.printBox("User canceled operation.");
    }
}