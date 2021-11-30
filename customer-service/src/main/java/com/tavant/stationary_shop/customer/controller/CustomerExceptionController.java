package com.tavant.stationary_shop.customer.controller;

import com.tavant.stationary_shop.customer.exception.CustomerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerExceptionController {

    @ExceptionHandler
    public ResponseEntity<String> customerNotFoundHandler(CustomerNotFoundException customerNotFoundException){
        return new ResponseEntity<>(customerNotFoundException.getMessage(), HttpStatus.OK);
    }
}
