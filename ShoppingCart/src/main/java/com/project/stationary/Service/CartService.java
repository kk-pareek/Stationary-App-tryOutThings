package com.project.stationary.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.project.stationary.Model.Product;
import com.project.stationary.Repository.ProductRepository;
import com.project.stationary.UIandUO.UserOutputCart;
import com.project.stationary.UIandUO.UserOutputProduct;
import com.project.stationary.exception.CartNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.stationary.Model.Cart;
import com.project.stationary.Repository.CartRepository;

@Service
public class CartService {

	private CartRepository repo;
	private ProductRepository productRepository;
	private ModelMapper modelMapper;

	@Autowired
	public CartService(CartRepository repo, ProductRepository productRepository) {
		this.repo = repo;
		this.productRepository = productRepository;
	}

	public List<Cart> getAllCarts() {
		return repo.findAll();
	}
	
	public Cart getCartById(Integer customerId){
		Optional<Cart> cart = repo.findById(customerId);

		if (!cart.isPresent()){
			return repo.save(new Cart(customerId, new ArrayList<>()));
		}

		return cart.get();
	}
	
	public void addNewCart(Cart theCart) {
		repo.save(theCart);
	}
	
	public Cart updateCart(Cart theCart) {
		return repo.save(theCart);
	}

	public Cart addNewProduct(Integer customerId, Product product){
		Cart cart = getCartById(customerId);
		List<Product> products = cart.getProducts();
		products.add(product);
		cart.setProducts(products);
		return repo.save(cart);
	}
	
	public Cart deleteAllProducts(Integer customerId) {
		Cart cart = getCartById(customerId);
		List<Product> products = cart.getProducts();
		for (Product product : products){
			productRepository.delete(product);
		}
		cart.setProducts(new ArrayList<>());
		return repo.save(cart);
	}
	
	public Cart deleteProductById(Integer customerId, Integer productId) {
		Cart cart = getCartById(customerId);
		List<Product> products;
		if (cart.getProducts().size() == 0){
			return cart;
		}else {
			products = cart.getProducts();
			for(Product product : products){
				if(product.getProductId() == productId){
					products.remove(product);
					productRepository.deleteById(product.getItemId());
					break;
				}
			}
		}

		return getCartById(customerId);
	}
}
