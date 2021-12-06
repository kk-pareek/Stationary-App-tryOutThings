package com.tavant.stationary_shop.customer.exception;

public class CustomerNotFoundException extends RuntimeException {
    private String message;

    public CustomerNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
