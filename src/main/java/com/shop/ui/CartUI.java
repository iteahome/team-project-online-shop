package com.shop.ui;

import com.shop.exception.ShopTechnicalException;
import com.shop.model.Product;
import com.shop.service.CartService;
import com.shop.ui.handlers.InputPopUps;

import static com.shop.ui.handlers.InputPopUps.CANCELLED;
import static java.lang.Integer.parseInt;

class CartUI {
    private CartService cartService = new CartService();

    private static final String Edit_CART = "1";
    private static final String CREATE_ORDER = "2";

    void manageCart() throws ShopTechnicalException {
        String userInput;
        StringBuilder stringBuilder = new StringBuilder();
        String dataToShow = "";
        do {
            stringBuilder.setLength(0);
            for (Product product : cartService.showKeys()) {
                stringBuilder.append(product.toString()).append(" ").append("Quantity: ").append(cartService.showQuantity(product).toString()).append("\n");
            }
            userInput = InputPopUps.input(dataToShow + "\n\nEdit Cart : 1\nCreate Order : 2\n\n" + stringBuilder);
            if (!userInput.equals(CANCELLED)) {
                switch (userInput) {
                    case Edit_CART: {
                            editCart(stringBuilder.toString());
                        }
                        break;
                    case CREATE_ORDER: {
                        cartService.createOrder();
                        break;
                    }
                    default: {
                        dataToShow = "Please insert valid option";
                    }
                }
            }
        } while (!userInput.equals(CANCELLED));
    }

    private void editCart(String stringBuilder) {
        String userInput;
        final String EDIT_QUANTITY = "1";
        final String DELETE_PRODUCT = "2";

        userInput = InputPopUps.input("Edit Quantity : 1\nDelete Product : 2\n\n" + stringBuilder);
        if (!userInput.equals(CANCELLED)) {
            switch (userInput) {
                case EDIT_QUANTITY: {
                    String productId = InputPopUps.input("Product to be modified:" + stringBuilder);
                    String newQuantity = InputPopUps.input("Quantity Desired:");
                    cartService.editQuantity(parseInt(productId), parseInt(newQuantity));
                    break;
                }
                case DELETE_PRODUCT: {
                    String productId = InputPopUps.input("Product to be deleted:" + stringBuilder);
                    cartService.deleteProduct(parseInt(productId));
                    break;
                }
            }
        }

    }
}
