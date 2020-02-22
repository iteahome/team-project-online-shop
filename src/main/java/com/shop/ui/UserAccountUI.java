package com.shop.ui;

import com.shop.model.User;
import com.shop.service.UserService;
import com.shop.ui.ui_handlers.InputPopUps;
import com.shop.ui.ui_handlers.PrintUI;

public class UserAccountUI {


    UserService userService = new UserService();
    private static final String CANCEL = "NullPointerExceptionFound";


    void manageAccount(User user) {
        /* will be called at ShopUI:36 */
        /* for this user, print details on screen */
        String userInput = null;
        final String VIEW_ACCOUNT_DATA = "1";
        final String MODIFY_ACCOUNT_DATA = "2";
        final String GO_BACK = "0";

        do {
            PrintUI.printBox("View Account Data : 1", "Modify Account Data : 2", "Go Back: 0");
            userInput = InputPopUps.input("Option:");

            switch (userInput) {
                case VIEW_ACCOUNT_DATA: {
                    PrintUI.printBox(user.printCompleteUserData());
                } break;

                case MODIFY_ACCOUNT_DATA: {
                    final String CHANGE_USERNAME = "1";
                    final String CHANGE_PASSWORD = "2";
                    final String CHANGE_PHONENO = "3";
                    PrintUI.printBox("Change Username : 1", "Change Password: 2", "Change Phone Number: 3");
                    String dataToChange = InputPopUps.input("Option:");
                    switch (dataToChange) {
                        case CHANGE_USERNAME: {
                            user.setUserName(InputPopUps.input("New Username:"));
                            if (!user.getUserName().equals(CANCEL)) {
                                userService.replaceUserData(user);
                            }
                        }
                        case CHANGE_PASSWORD: {}
                        case CHANGE_PHONENO: {}
                    }
                } break;

                case GO_BACK: {
                    break;

                }
                default: {
                    PrintUI.printBox("Please insert a valid option");
                }
            }
        } while (!userInput.equals(GO_BACK));
    }

}
