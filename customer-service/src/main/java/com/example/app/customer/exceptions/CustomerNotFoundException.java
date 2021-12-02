package com.example.app.customer.exceptions;


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
