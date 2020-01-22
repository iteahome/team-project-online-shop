package com.shop.exception;

public class ShopWrongCredentialsException extends ShopBusinessException {
    public ShopWrongCredentialsException () {

    }
        public ShopWrongCredentialsException(String message, Throwable cause) {
            super(message, cause);
        }
    }

