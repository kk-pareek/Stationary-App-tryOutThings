package com.project.stationary.Controller;

import java.util.List;
import java.util.Optional;

import com.project.stationary.Dto.CartDto;
import com.project.stationary.Model.Product;
import com.project.stationary.UIandUO.UserOutputCart;
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
@RequestMapping("api/cart")
public class CartController {

	private CartService service;
	private CartDto cartDto;

	@Autowired
	public CartController(CartService service, CartDto cartDto) {
		this.service = service;
		this.cartDto = cartDto;
	}

	@GetMapping
	public ResponseEntity<String> getStatus(){
		return new ResponseEntity<>("Cart service is up and running....", HttpStatus.OK);
	}
	
	
	@GetMapping("all")
	 public ResponseEntity<List<Cart>> getAllCarts(){
		return new ResponseEntity<>(service.getAllCarts(),HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<UserOutputCart> getCartById(@PathVariable("id") Integer customerId){
		return new ResponseEntity<>(cartDto.getCartById(customerId),HttpStatus.OK);
	}
	
	@PostMapping("add")
	public void addNewCart(@RequestBody Cart theCart) {
		service.addNewCart(theCart);
	}

	@PostMapping("add/product/{id}")
    public Cart addNewProduct(@PathVariable("id") Integer customerId, @RequestBody Product product){
		return service.addNewProduct(customerId, product);
    }
	
	@PutMapping("update")
	public void updateCart(@RequestBody Cart theCart) {
		service.updateCart(theCart);
	}
	
	@DeleteMapping("delete/{customerId}")
	public Cart deleteAll(@PathVariable("customerId") Integer customerId) {
		return service.deleteAllProducts(customerId);
	}
	
	@DeleteMapping("delete/{customerId}/{productId}")
	public Cart deleteByProductId(@PathVariable("customerId") Integer customerId, @PathVariable("productId") Integer productId) {
		return service.deleteProductById(customerId, productId);
	}
}
