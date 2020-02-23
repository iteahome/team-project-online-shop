package com.shop.ui;

import com.shop.ui.handlers.InputPopUps;
import com.shop.ui.handlers.PrintUI;
import com.shop.exception.ShopException;
import com.shop.security.UserContext;

import static com.shop.ui.handlers.InputPopUps.CANCELLED;

class ShopUI {

    private static final String OPTION_SHOP = "1";
    private static final String OPTION_ACCOUNT = "2";
    private static final String OPTION_LOGOUT = "0";

    private AdminShopUI adminShopUI = new AdminShopUI();
    private AdminManageAccountsUI adminManageAccountsUI = new AdminManageAccountsUI();
    private UserShopUI userShopUi = new UserShopUI();
    private UserAccountUI userAccountUI = new UserAccountUI();

    public void start() throws ShopException {
        String userInput;
        do {
            userInput = InputPopUps.input("Welcome to our online shop!\n\nShop: 1\nManage account: 2\nLog out: 0");
            switch (userInput) {
                case OPTION_SHOP: {
                    if (UserContext.isAdminLogged()) {
                        adminShopUI.manageProducts();
                    } else {
                        userShopUi.browseProducts();
                    }
                    break;
                }
                case OPTION_ACCOUNT: {
                    if (UserContext.isAdminLogged()) {
                        adminManageAccountsUI.manageAccounts();
                    } else {
                        userAccountUI.manageAccount(UserContext.getLoggedUser());
                    }
                    break;
                }
                case OPTION_LOGOUT: {
                    UserContext.setLoggedUser(null);
                    PrintUI.printBox("You are now logged out.");
                    break;
                }
                case CANCELLED: {
                    PrintUI.printBox("User canceled operation.");
                    break;
                }
                default: {
                    PrintUI.printBox("Please enter a valid option.");
                }
            }
        } while (!userInput.equals(OPTION_LOGOUT));
    }
}
