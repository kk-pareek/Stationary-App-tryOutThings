package com.example.app.category.exceptions;

public class CategoryNotFoundException extends RuntimeException{
    private String message;

    public CategoryNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
