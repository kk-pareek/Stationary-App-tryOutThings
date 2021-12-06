package com.project.stationary.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.project.stationary.exception.CartNotFoundException;

@ControllerAdvice
public class CartExceptionController extends RuntimeException {
	@ExceptionHandler
	public ResponseEntity<String> cartNotFoundExceptionHandler(CartNotFoundException cartNotFoundException){
		return new ResponseEntity<>(cartNotFoundException.getMessage(),HttpStatus.NOT_FOUND);
	}
}
