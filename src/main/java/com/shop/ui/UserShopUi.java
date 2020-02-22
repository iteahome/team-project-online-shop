package com.shop.ui;

import com.shop.exception.ShopException;
import com.shop.model.Product;
import com.shop.service.ProductService;
import com.shop.ui.ui_handlers.InputPopUps;
import com.shop.ui.ui_handlers.PrintUI;

public class UserShopUi {
    private ProductService productService = new ProductService();
    private static final String CANCEL = "NullPointerExceptionFound";

    void browseProducts() throws ShopException {
        String userInput = null;
        final String EXIT_MENU = "0";
        do {
            userInput = InputPopUps.input("Shop Menu\nFilter Products : 1\nExit : 0");
            final String FILTER_PRODUCTS = "1";
            switch (userInput) {
                case FILTER_PRODUCTS: {
                    String categoryName = InputPopUps.input("Filter by Category: ");
                    String productName = InputPopUps.input("Filter by Product Name: ");
                    for (Product product : productService.getProductsByCategoryAndName(categoryName, productName)) {
                        {
                            PrintUI.printBox(product.toString());
                        }
                    }
                    userInput = InputPopUps.input("in");
//                    switch (userInput) {

//                    }
                }
                break;
                case CANCEL: {
                    PrintUI.printBox("User canceled operation.");
                    break;
                }
                case EXIT_MENU: {
                    break;
                }
                default: {
                    PrintUI.printBox("Please choose a valid option");
                }

            }
        } while (!userInput.equals(EXIT_MENU));

    }
}
