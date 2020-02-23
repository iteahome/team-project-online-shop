package com.shop.ui;

import com.shop.exception.ProductNotFoundException;
import com.shop.exception.ShopTechnicalException;
import com.shop.model.Product;
import com.shop.service.CartService;
import com.shop.ui.handlers.InputPopUps;
import com.shop.ui.handlers.PrintUI;

import static com.shop.ui.handlers.InputPopUps.CANCELLED;
import static java.lang.Integer.parseInt;

public class CartUI {
    private CartService cartService = new CartService();

    private static final String Edit_CART = "1";
    private static final String EXIT = "0";
    private static final String CREATE_ORDER = "2";

    public void manageCart() throws ShopTechnicalException, ProductNotFoundException {
        String userInput;

        do {
            for (Product product : cartService.showKeys()) {
                PrintUI.printBox(product.toString(), "Quantity: " + cartService.showQuantity(product).toString());
            }
            userInput = InputPopUps.input("Edit Cart : 1\nCreate Order : 2\nKeep Shopping : 0");
            if (!userInput.equals(CANCELLED)) {
                switch (userInput) {
                    case Edit_CART: {
                            editCart();
                        }
                        break;
                    case CREATE_ORDER: {
                        cartService.createOrder();
                        break;
                    }
                    case EXIT: {
                        break;
                    }

                    default: {
                        PrintUI.printBox("Please insert valid option");
                    }
                }
            }
        } while (!userInput.equals(EXIT));
    }

    private void editCart() {
        String userInput;
        final String EDIT_QUANTITY = "1";
        final String DELETE_PRODUCT = "2";

        userInput = InputPopUps.input("Edit Quantity : 1\nDelete Product : 2");
        if (!userInput.equals(CANCELLED)) {
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
}
