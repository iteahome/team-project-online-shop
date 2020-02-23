package com.shop.ui;

import com.shop.exception.ShopException;
import com.shop.model.User;
import com.shop.service.UserService;
import com.shop.ui.handlers.InputPopUps;
import com.shop.ui.handlers.PrintUI;

import static com.shop.ui.handlers.InputPopUps.CANCELLED;

/** UserAccountUI class - connects user input to UserService class to manage account data. */

public class UserAccountUI {

    final String GO_BACK = "0";
    final String VIEW_ACCOUNT = "1";
    final String MODIFY_ACCOUNT = "2";

    final String CHANGE_USERNAME = "1";
    final String CHANGE_PASSWORD = "2";
    final String CHANGE_PHONENO = "3";

    UserService userService = new UserService();

    void manageAccount(User user) {
        String userInput;
        do {
            userInput = InputPopUps.input("View account: 1\nModify account: 2\nGo Back: 0");
            switch (userInput) {
                case VIEW_ACCOUNT:
                    PrintUI.printBox(user.printCompleteUserData());
                    break;

                case MODIFY_ACCOUNT:
                    modifyAccount(user);
                    break;

                case GO_BACK:
                    break;

                default:
                    PrintUI.printBox("Please enter a valid option:");
            }
        } while (!userInput.equals(GO_BACK));
    }

    private void changeUserName(User user) {
        String newUserName = InputPopUps.input("Enter new username:");
        if (!newUserName.equals(CANCELLED)) {
            user.setUserName(newUserName);
            try {
                userService.replaceUserData(user);
            } catch (ShopException e) {
                e.printStackTrace();
            }
        }
    }

    private void changePassword(User user) {
        String newPassword = InputPopUps.input("Enter new password:");
        if (!newPassword.equals(CANCELLED)) {
            user.setPassword(newPassword);
            try {
                userService.replaceUserData(user);
            } catch (ShopException e) {
                e.printStackTrace();
            }
        }
    }

    private void changePhoneNo(User user) {
        String newPhoneNo = InputPopUps.input("Enter new phone number:");
        if (!newPhoneNo.equals(CANCELLED)) {
            user.setPhoneNo(newPhoneNo);
            try {
                userService.replaceUserData(user);
            } catch (ShopException e) {
                e.printStackTrace();
            }
        }
    }

    private void modifyAccount(User user) {
        String dataToChange = InputPopUps.input("Change username: 1\nChange password: 2\nChange phone number: 3");
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
        }
    }
}