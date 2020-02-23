package com.shop.ui;

import com.shop.exception.ProductNotFoundException;
import com.shop.exception.ShopFileException;
import com.shop.model.Product;
import com.shop.service.CartService;
import com.shop.service.ProductService;
import com.shop.ui.handlers.InputPopUps;
import com.shop.ui.handlers.PrintUI;

import static java.lang.Integer.parseInt;

public class CartUI {
    private CartService cartService = new CartService();
    ProductService productService = new ProductService();

    private static final String Edit_CART = "1";
    private static final String EXIT = "0";

    public void manageCart() throws ShopFileException, ProductNotFoundException {
        String userInput;

        do {
            for (Product product : cartService.showKeys()) {
                PrintUI.printBox(product.toString(), "Quantity: " + cartService.showQuantity(product).toString());
            }
            userInput = InputPopUps.input("Edit Cart : 1\nKeep Shopping : 0");
            switch (userInput) {
                case Edit_CART: {
                    editCart();
                    break;
                }
                case EXIT: {
                    break;
                }

                default: {
                    PrintUI.printBox("Please insert valid option");
                }
            }

        } while (!userInput.equals(EXIT));
    }

    private void editCart() throws ShopFileException, ProductNotFoundException {
        String userInput;
        final String EDIT_QUANTITY = "1";
        final String DELETE_PRODUCT = "2";

        userInput = InputPopUps.input("Edit Quantity : 1\nDelete Product : 2");
        switch (userInput) {
            case EDIT_QUANTITY: {
                String productId = InputPopUps.input("Product to be modified:");
                String newQuantity = InputPopUps.input("Quantity Desired:");
                cartService.editQuantity(parseInt(productId), parseInt(newQuantity));
                break;
            }
            case DELETE_PRODUCT: {
                String productId = InputPopUps.input("Product to be deleted:");
                cartService.deleteProduct(parseInt(productId));
            }
        }

    }
}
