package com.shop.ui;

import com.shop.OnlineShop;
import com.shop.datahandlers.formatter.InputPopUps;
import com.shop.datahandlers.formatter.PrintUI;
import com.shop.exception.ShopException;
import com.shop.exception.ShopTechnicalException;
import com.shop.service.ProductService;

import java.io.IOException;
import java.util.Scanner;

public class AdminShopUI {

    public void manageProducts () throws ShopException {
        PrintUI.printBox("Admin Menu: ", "Create new products : 1", "Filter Products : 2", "Exit : 3");
        String userInput = "";
        try {
            userInput = InputPopUps.main("Option: ");
        } catch(NullPointerException e) {
            userInput = "3";
        }
        if (userInput.equals("1")) {
            PrintUI.printBox("Please insert new product name: ");
            String inputProdName = InputPopUps.main("Product Name: ");
            PrintUI.printBox("Please insert new product category: ");
            String inputProdCategory = InputPopUps.main("Product Category: ");
            PrintUI.printBox("Please insert new product quantity: ");
            String inputProdQuantity = InputPopUps.main("Product Quantity: ");
            PrintUI.printBox("Please insert new product price: ");
            String inputProdPrice = InputPopUps.main("Product Price: ");
            ProductService.addProduct(inputProdName, inputProdCategory, inputProdQuantity, inputProdPrice);
            PrintUI.printBox("Product Created.");
            manageProducts();
        }
        if (userInput.equals("2")) {
            PrintUI.printBox("Please insert part of the product category and name as requested (blank accepted).");
            String categoryName =  InputPopUps.main("Category: ");;
            String productName = InputPopUps.main("Product Name: ");;

            ProductService.displayProductsByCategoryAndName(categoryName, productName);
            manageProducts();
        }
        if (userInput.equals("3")) {
        //This part is about to be added latter on the code
            PrintUI.printBox("this should get us on previous UI");
            MainUI mainUI = new MainUI();
            mainUI.start();
        }

    }

}
