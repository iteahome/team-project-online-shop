package com.shop.ui;

import com.shop.datahandlers.formatter.InputPopUps;
import com.shop.datahandlers.formatter.PrintUI;
import com.shop.exception.ShopException;
import com.shop.model.Product;
import com.shop.service.ProductService;

public class AdminShopUI {
    private ProductService productService = new ProductService();

    void manageProducts() throws ShopException {
        PrintUI.printBox("Admin Menu: ", "Create new products : 1", "Filter Products : 2", "Exit : 0");
        String userInput = null;
        final String exitMenu = "0";
        do {
            userInput = InputPopUps.input("Option: ");
            final String createProduct = "1";
            final String filterProducts = "2";
            switch (userInput) {
                case createProduct: {
                    PrintUI.printBox("Please insert new product name: ");
                    String inputProdName = InputPopUps.input("Product Name: ");
                    PrintUI.printBox("Please insert new product category: ");
                    String inputProdCategory = InputPopUps.input("Product Category: ");
                    PrintUI.printBox("Please insert new product quantity: ");
                    String inputProdQuantity = InputPopUps.input("Product Quantity: ");
                    PrintUI.printBox("Please insert new product price: ");
                    String inputProdPrice = InputPopUps.input("Product Price: ");
                    ProductService.addProduct(inputProdName, inputProdCategory, inputProdQuantity, inputProdPrice);
                    PrintUI.printBox("Product Created.");
                    break;
                }
                case filterProducts: {
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

                case exitMenu: {
                    break;
                }
                default: {
                    PrintUI.printBox("Please choose a valid option");
                }

            }
        } while (!userInput.equals(exitMenu));

    }
}