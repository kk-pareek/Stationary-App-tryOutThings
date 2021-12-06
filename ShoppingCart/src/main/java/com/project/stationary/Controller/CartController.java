package com.project.stationary.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.stationary.Model.Cart;
import com.project.stationary.Service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
	@Autowired
	CartService service;
	
	@GetMapping
	public ResponseEntity<String> getStatus(){
		return new ResponseEntity<>("Cart service is up and running....", HttpStatus.OK);
	}
	
	
	@GetMapping("/view")
	 public ResponseEntity<Iterable<Cart>> getAllCarts(){
		return new ResponseEntity<>(service.getAllCarts(),HttpStatus.OK);
	}
	
	@GetMapping("/view/{Id}")
	public ResponseEntity<Optional<Cart>> getCartById(@PathVariable Integer Id){
		return new ResponseEntity<>(service.getCartById(Id),HttpStatus.FOUND);
	}
	
	@PostMapping("/add")
	void addNewCart(@RequestBody Cart theCart) {
		service.addNewCart(theCart);
	}
	
	@PutMapping("/update")
	void updateCart(@RequestBody Cart theCart) {
		service.updateCart(theCart);
	}
	
	@DeleteMapping("/delete/all")
	void deleteAll() {
		service.deleteAll();
	}
	
	@DeleteMapping("/delete/{Id}")
	void deleteById(@PathVariable Integer Id) {
		service.deleteById(Id);
	}
}
