package com.shop.ui;

import com.shop.exception.ShopException;
import com.shop.model.User;
import com.shop.service.UserService;
import com.shop.ui.handlers.InputPopUps;
import com.shop.ui.handlers.PrintUI;
import com.shop.ui.validator.PhoneNoValidator;

import static com.shop.ui.handlers.InputPopUps.CANCELLED;

/**
 * UserAccountUI class - connects user input to UserService class to manage account data.
 */

public class UserAccountUI {

    private static final String VIEW_ACCOUNT = "1";
    private static final String MODIFY_ACCOUNT = "2";
    private static final String GO_BACK = "0";

    private static final String CHANGE_USERNAME = "1";
    private static final String CHANGE_PASSWORD = "2";
    private static final String CHANGE_PHONENO = "3";

    private UserService userService = new UserService();
    private PhoneNoValidator phoneNoValidator = new PhoneNoValidator();

    void manageAccount(User user) throws ShopException {
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
                case CANCELLED:
                    break;
                default:
                    PrintUI.printBox("Please enter a valid option:");
            }
        } while (!userInput.equals(GO_BACK));
    }

    private void modifyAccount(User user) throws ShopException {
        String dataToChange;
        do {
            dataToChange = InputPopUps.input("Modify account menu:\n\nChange username: 1\nChange password: 2\nChange phone number: 3");
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
                case CANCELLED:
                    break;
                default:
                    PrintUI.printBox("Please enter a valid option:");
            }
        } while (!dataToChange.equals(CANCELLED));
    }

    private void changeUserName(User user) throws ShopException {
        String newUserName;
        do {
            newUserName = InputPopUps.input("Enter new username:");
            switch (newUserName) {
                case CANCELLED: {
                    break;
                }

                default: {
                    user.setUserName(newUserName);
                    userService.replaceUserData(user);
                    newUserName = CANCELLED;
                    break;
                }
                case ".": {
                    PrintUI.printBox("Please choose a valid userName");
                }
            }
        } while (!newUserName.equals(CANCELLED));
    }

    private void changePassword(User user) throws ShopException {
        String newPassword;
        do {
            newPassword = InputPopUps.input("Enter new password:");
            switch (newPassword) {
                case CANCELLED: {
                    break;
                }

                default: {
                    user.setPassword(newPassword);
                    userService.replaceUserData(user);
                    newPassword = CANCELLED;
                    break;
                }
                case ".": {
                    PrintUI.printBox("Please choose a valid password");
                }
            }
        } while (!newPassword.equals(CANCELLED));
    }


    private void changePhoneNo(User user) throws ShopException {
        String newPhoneNo = InputPopUps.input("Enter new Romanian phone number:");
        do {
            if (phoneNoValidator.isPhoneNoValid((newPhoneNo))) {
                newPhoneNo = phoneNoValidator.formatPhoneNo(newPhoneNo);
                user.setPhoneNo(newPhoneNo);
                userService.replaceUserData(user);
                newPhoneNo = CANCELLED;
            } else {
                newPhoneNo = InputPopUps.input("Invalid number. Please try again:");
            }

        } while (!newPhoneNo.equals(CANCELLED));

    }
}