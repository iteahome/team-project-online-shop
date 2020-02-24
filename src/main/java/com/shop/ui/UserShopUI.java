package com.shop.ui;

import com.shop.exception.ShopException;
import com.shop.model.Product;
import com.shop.service.CartService;
import com.shop.service.ProductService;
import com.shop.ui.handlers.InputPopUps;
import com.shop.ui.handlers.PrintUI;

import static com.shop.ui.handlers.InputPopUps.CANCELLED;
import static java.lang.Integer.parseInt;

public class UserShopUI {
    private ProductService productService = new ProductService();
    private CartService cartService = new CartService();
    CartUI cartUI = new CartUI();

    private static final String EXIT_MENU = "0";
    private static final String FILTER_PRODUCTS = "1";
    private static final String VIEW_CART = "2";
    private static final String ADD_TO_CART = "1";
    private static final String G0_BACK = "3";

    void browseProducts() throws ShopException {
        String userInput = null;
        do {
            userInput = InputPopUps.input("Shop Menu:\n\nFilter Products : 1\nView Cart : 2\nExit : 3");
            switch (userInput) {
                case FILTER_PRODUCTS: {
                    filterProducts();
                    break;
                }
                case VIEW_CART: {
                    if (!cartService.isCartNull) {
                        cartUI.manageCart();
                    } else {
                        PrintUI.printBox("Your Shopping Cart is empty");
                    }
                    break;
                }
                case CANCELLED:
                case G0_BACK: {
                    break;
                }
                default: {
                    PrintUI.printBox("Please choose a valid option");
                }

            }
        } while (!userInput.equals(G0_BACK));

    }

    private void filterProducts() {
        String userInput = "";
        String categoryName = "";
        String productName = "";
        do {
            categoryName = InputPopUps.input("Filter by Category: ");
            productName = InputPopUps.input("Filter by Product Name: ");
            StringBuilder filteredProducts = new StringBuilder();
            if (!categoryName.equals(CANCELLED) && !productName.equals(CANCELLED)) {
                filteredProducts.setLength(0);
                filteredProducts.append("\n");
                for (Product product : productService.getProductsByCategoryAndName(categoryName, productName)) {
                    filteredProducts.append(product.toString()).append("\n");
                }
                userInput = InputPopUps.input(filteredProducts + "\n\nAdd Product to cart : 1\nContinue Browsing : 0");
                switch (userInput) {
                    case ADD_TO_CART: {
                        String productIdForCart = InputPopUps.input(filteredProducts + "\n\nID of the product to be added: ");
                        String quantity = InputPopUps.input("Quantity Desired: ");
                        if (!productIdForCart.equals(CANCELLED) && !quantity.equals(CANCELLED)) {
                            cartService.addToCart(productService.getProductByID(parseInt(productIdForCart)), parseInt(quantity));
                            break;
                        }
                    }
                    case CANCELLED : {
                        break;
                    }
                }
            }
        } while (!userInput.equals(CANCELLED) && !categoryName.equals(CANCELLED) && !productName.equals(CANCELLED));
    }
}
