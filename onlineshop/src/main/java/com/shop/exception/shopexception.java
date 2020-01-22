package com.shop.exception;

public class ShopException extends Exception {

    public ShopException() {
    }

    public ShopException (String message, Throwable cause) {
        super(message, cause);
    }
}
