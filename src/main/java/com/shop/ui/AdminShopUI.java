package com.shop.ui;

import com.shop.exception.ShopFileException;
import com.shop.exception.ShopTechnicalException;
import com.shop.ui.handlers.InputPopUps;
import com.shop.ui.handlers.PrintUI;
import com.shop.exception.ShopException;
import com.shop.model.Product;
import com.shop.service.ProductService;

import static com.shop.ui.handlers.InputPopUps.CANCELLED;

public class AdminShopUI {

    private static final String EXIT_MENU = "0";
    private static final String CREATE_PRODUCT = "1";
    private static final String FILTER_PRODUCTS = "2";

    private ProductService productService = new ProductService();

    public void manageProducts() throws ShopException {
        String userInput = null;
        do {
            PrintUI.printBox("Admin Menu: ", "Create new products : 1", "Filter Products : 2", "Exit : 0");
            userInput = InputPopUps.input("Option: ");
            switch (userInput) {
                case CREATE_PRODUCT:
                    showAddProduct();
                    break;
                case FILTER_PRODUCTS:
                    showFilterProducts();
                    break;
                case CANCELLED:
                    PrintUI.printBox("User canceled operation.");
                    break;
                case EXIT_MENU:
                    break;
                default:
                    PrintUI.printBox("Please choose a valid option");
            }
        } while (!userInput.equals(EXIT_MENU));
    }

    private void showFilterProducts() throws ShopFileException {
        PrintUI.printBox("Please insert part of the product category and name as requested (blank accepted).");
        String categoryName = InputPopUps.input("Category: ");
        String productName = InputPopUps.input("Product Name: ");
        // TODO - check where is the IF
        for (Product product : productService.getProductsByCategoryAndName(categoryName, productName)) {
            PrintUI.printBox(product.toString());
        }
    }

    private void showAddProduct() throws ShopTechnicalException {
        PrintUI.printBox("Please insert new product name: ");
        String inputProdName = InputPopUps.input("Product Name: ");

        PrintUI.printBox("Please insert new product category: ");
        String inputProdCategory = InputPopUps.input("Product Category: ");

        PrintUI.printBox("Please insert new product quantity: ");
        String inputProdQuantity = InputPopUps.input("Product Quantity: ");

        PrintUI.printBox("Please insert new product price: ");
        String inputProdPrice = InputPopUps.input("Product Price: ");

        if (!inputProdCategory.equals(CANCELLED) && !inputProdName.equals(CANCELLED) && !inputProdPrice.equals(CANCELLED) && !inputProdQuantity.equals(CANCELLED)) {
            productService.addProduct(inputProdName, inputProdCategory, inputProdQuantity, inputProdPrice);
            PrintUI.printBox("Product Created.");
        } else {
            PrintUI.printBox("User Canceled operation.");
        }
    }
}