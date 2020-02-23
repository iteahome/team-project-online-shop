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
    private  CartService cartService = new CartService();
    CartUI cartUI = new CartUI();

    private static final String EXIT_MENU = "0";
    private static final String FILTER_PRODUCTS = "1";
    private static final String VIEW_CART = "2";


    void browseProducts() throws ShopException {
        String userInput = null;
        do {
            userInput = InputPopUps.input("Shop Menu:\n\nFilter Products : 1\nView Cart : 2\nExit : 0");
            switch (userInput) {
                case FILTER_PRODUCTS: {
                    String categoryName = InputPopUps.input("Filter by Category: ");
                    String productName = InputPopUps.input("Filter by Product Name: ");
                    for (Product product : productService.getProductsByCategoryAndName(categoryName, productName)) {
                        PrintUI.printBox(product.toString());
                    }
                    userInput = InputPopUps.input("Add Product to cart : 1\nContinue Browsing : 0");
                    final String ADD_TO_CART = "1";
                    switch (userInput) {
                        case EXIT_MENU: {
                            break;
                        }
                        case ADD_TO_CART: {
                            String productIdForCart = InputPopUps.input("ID of the product to be added: ");
                            String quantity = InputPopUps.input("Quantity Desired: ");
                            if (!productIdForCart.equals(CANCELLED) & !quantity.equals(CANCELLED)) {
                                cartService.addToCart(productService.getProductByID(parseInt(productIdForCart)), parseInt(quantity));
                            }
                        }

                    }
                }
                break;
                case VIEW_CART : {
                    cartUI.viewCart();
                    break;
                }
                case CANCELLED: {
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
