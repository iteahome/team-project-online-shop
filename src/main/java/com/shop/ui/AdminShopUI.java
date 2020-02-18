package com.shop.ui;

import com.shop.datahandlers.formatter.PrintUI;
import com.shop.exception.ShopTechnicalException;
import com.shop.service.ProductService;

import java.util.Scanner;

public class AdminShopUI {

    public void manageProducts () throws ShopTechnicalException {
        PrintUI.printBox("Admin Menu: ", "Create new products : 1", "Filter Products : 2", "Exit : 3");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        if (userInput.equals("1")) {
            PrintUI.printBox("Please insert new product name: ");
            String inputProdName = scanner.nextLine();
            PrintUI.printBox("Please insert new product category: ");
            String inputProdCategory = scanner.nextLine();
            PrintUI.printBox("Please insert new product quantity: ");
            String inputProdQuantity = scanner.nextLine();
            PrintUI.printBox("Please insert new product price: ");
            String inputProdPrice = scanner.nextLine();
            ProductService.addProduct(inputProdName, inputProdCategory, inputProdQuantity, inputProdPrice);
            PrintUI.printBox("Product Created.");
            manageProducts();
        }
        if (userInput.equals("2")) {
            PrintUI.printBox("Please insert part of the product category and name as requested (blank accepted).", "Category: ");
            String categoryName = "";
            if (scanner.hasNextLine()) {
                categoryName = scanner.nextLine();
            }
            PrintUI.printBox("Name: ");
            String productName = "";
            if (scanner.hasNextLine()) {
                productName = scanner.nextLine();
            }
            ProductService.displayProductsByCategoryAndName(categoryName, productName);
            manageProducts();
        }
        if (userInput.equals("3")) {
        //This part is about to be added latter on the code
            PrintUI.printBox("this should get us on previous UI");
        }

    }

}
