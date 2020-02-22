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
    private UserShopUi userShopUi = new UserShopUi();

    public void start() throws ShopException {
        String userInput = null;
        do {
            userInput = InputPopUps.input("Welcome to Our Shop\nShop : 1\nAccount : 2\nLogout : 0");
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
                        PrintUI.printBox("User account");
                    }
                    break;
                }
                case OPTION_LOGOUT: {
                    UserContext.setLoggedUser(null);
                    PrintUI.printBox("Logging out");
                    break;
                }
                case CANCELLED: {
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
