package com.shop.exception;

public class UserAlreadyExistsException extends ShopBusinessException {
    public UserAlreadyExistsException () {
    }
    public UserAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
