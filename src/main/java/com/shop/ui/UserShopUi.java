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
            PrintUI.printBox("Shop Menu: ", "Filter Products : 1", "Exit : 0");
            userInput = InputPopUps.input("Option: ");
            final String FILTER_PRODUCTS = "1";
            switch (userInput) {
                case FILTER_PRODUCTS: {
                    PrintUI.printBox("Please insert part of the product category and name as requested (blank accepted).");
                    String categoryName = InputPopUps.input("Category: ");
                    String productName = InputPopUps.input("Product Name: ");
                    for (Product product : productService.getProductsByCategoryAndName(categoryName, productName)) {
                        {
                            PrintUI.printBox(product.toString());
                        }
                    }
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
