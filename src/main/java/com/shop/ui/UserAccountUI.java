package com.shop.ui;

import com.shop.exception.ShopException;
import com.shop.model.User;
import com.shop.service.UserService;
import com.shop.ui.handlers.InputPopUps;
import com.shop.ui.handlers.PrintUI;

import static com.shop.ui.handlers.InputPopUps.CANCELLED;

public class UserAccountUI {


    UserService userService = new UserService();

    void manageAccount(User user) {

        final String VIEW_ACCOUNT_DATA = "1";
        final String MODIFY_ACCOUNT_DATA = "2";
        final String GO_BACK = "0";

        final String CHANGE_USERNAME = "1";
        final String CHANGE_PASSWORD = "2";
        final String CHANGE_PHONENO = "3";

        String userInput = null;

        do {
            userInput = InputPopUps.input("View account: 1 | Modify account: 2 | Go Back: 0");

            switch (userInput) {
                case VIEW_ACCOUNT_DATA:
                    PrintUI.printBox(user.printCompleteUserData());
                    break;

                case MODIFY_ACCOUNT_DATA: {
                    String dataToChange = InputPopUps.input("Change username: 1 | Change password: 2 | Change phone number: 3");
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
                break;

                case GO_BACK: {
                    break;
                }

                default: {
                    PrintUI.printBox("Please enter a valid option:");
                }
            }
        } while (!userInput.equals(GO_BACK));
    }

    private void changePhoneNo(User user) {
        user.setPhoneNo(InputPopUps.input("Enter new phone number:"));
        if (!user.getPhoneNo().equals(CANCELLED)) {
            try {
                userService.replaceUserData(user);
            } catch (ShopException e) {
                e.printStackTrace();
            }
        }
    }

    private void changePassword(User user) {
        user.setPassword(InputPopUps.input("Enter new password:"));
        if (!user.getPassword().equals(CANCELLED)) {
            try {
                userService.replaceUserData(user);
            } catch (ShopException e) {
                e.printStackTrace();
            }
        }
    }

    private void changeUserName(User user) {
        user.setUserName(InputPopUps.input("Enter new username:"));
        if (!user.getUserName().equals(CANCELLED)) {
            try {
                userService.replaceUserData(user);
            } catch (ShopException e) {
                e.printStackTrace();
            }
        }
    }
}