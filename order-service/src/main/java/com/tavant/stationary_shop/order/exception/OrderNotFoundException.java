package com.tavant.stationary_shop.order.exception;

public class OrderNotFoundException extends RuntimeException {
    private String message;

    public OrderNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
