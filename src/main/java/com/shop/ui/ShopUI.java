package com.shop.ui;

import com.shop.ui.ui_handlers.InputPopUps;
import com.shop.ui.ui_handlers.PrintUI;
import com.shop.exception.ShopException;
import com.shop.security.UserContext;

class ShopUI {
    private static final String CANCEL = "NullPointerExceptionFound";
    private AdminShopUI adminShopUI = new AdminShopUI();
    private AdminManageAccountsUI adminManageAccountsUI = new AdminManageAccountsUI();
    private UserShopUi userShopUi = new UserShopUi();
    void start() throws ShopException {
        String userInput = null;
        final String OPTION_SHOP = "1";
        final String OPTION_ACCOUNT = "2";
        final String OPTION_LOGOUT = "0";
        do {
            userInput = InputPopUps.input("Welcome to Our Shop\nShop : 1\nAccount : 2\nLogout : 0");
                    switch (userInput) {
                        case OPTION_SHOP : {
                            if (UserContext.isAdminLogged()){
                                adminShopUI.manageProducts();
                            }
                            else {
                                userShopUi.browseProducts();
                            }
                            break;
                        }
                        case OPTION_ACCOUNT : {
                            if (UserContext.isAdminLogged()){
                                adminManageAccountsUI.manageAccounts();
                            }
                            else {
                                PrintUI.printBox("User account");
                            }
                            break;
                        }
                        case OPTION_LOGOUT : {
                            UserContext.setLoggedUser(null);
                            PrintUI.printBox("Logging out");
                            break;
                        }
                        case CANCEL: {
                            PrintUI.printBox("User canceled operation.");
                            break;
                        }
                        default: {
                            PrintUI.printBox("Please insert a valid option.");
                        }
                    }
        } while (!userInput.equals(OPTION_LOGOUT));
    }
}
