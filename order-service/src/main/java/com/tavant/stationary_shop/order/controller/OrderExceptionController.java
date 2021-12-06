package com.tavant.stationary_shop.order.controller;

import com.tavant.stationary_shop.order.exception.OrderNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class OrderExceptionController extends RuntimeException {

    @ExceptionHandler
    public ResponseEntity<String> orderNotFoundExceptionHandler(OrderNotFoundException orderNotFoundException){
        return new ResponseEntity<>(orderNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }
}
