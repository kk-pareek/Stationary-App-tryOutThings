package com.example.app.category.controllers;

import com.example.app.category.exceptions.CategoryNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CategoryExceptionController {
    @ExceptionHandler
    public ResponseEntity<String> customerNotFoundHandler(CategoryNotFoundException customerNotFoundException){
        return new ResponseEntity<>(customerNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

}
