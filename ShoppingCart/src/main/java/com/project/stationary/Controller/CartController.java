package com.project.stationary.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@GetMapping("/view")
	Iterable<Cart> getAllCarts(){
		return service.getAllCarts();
	}
	
	@GetMapping("/view/{Id}")
	Optional<Cart> getCartById(@PathVariable Integer Id){
		return service.getCartById(Id);
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
