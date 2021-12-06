package com.project.stationary.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.stationary.Model.Cart;
import com.project.stationary.Repository.CartRepository;

@Service
public class CartService {
	@Autowired
	CartRepository repo;
	
	public Iterable<Cart> getAllCarts() {
		return repo.findAll();
	}
	
	public Optional<Cart> getCartById(Integer Id){
		return repo.findById(Id);
	}
	
	public void addNewCart(Cart theCart) {
		repo.save(theCart);
	}
	
	public void updateCart(Cart theCart) {
		repo.save(theCart);
	}
	
	public void deleteAll() {
		repo.deleteAll();
	}
	
	public void deleteById(Integer Id) {
		repo.deleteById(Id);
	}
}
