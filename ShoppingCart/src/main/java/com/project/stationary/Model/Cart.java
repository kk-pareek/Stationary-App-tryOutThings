package com.project.stationary.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cartId;
	
	@Column(unique = true)
	private Integer customerId;
	
	
	@Column
	private Integer quantity;
	
    @OneToMany(targetEntity = Product.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_product_fk", referencedColumnName = "cartId")
    private List<Product> products;
	
	public Cart(Integer cartId, Integer customerId, Integer quantity, List<Product> products) {
		super();
		this.cartId = cartId;
		this.customerId = customerId;
		this.quantity = quantity;
		this.products = products;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public Integer getCartId() {
		return cartId;
	}
	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Cart(Integer cartId, Integer customerId, Integer productId, Integer quantity) {
		super();
		this.cartId = cartId;
		this.customerId = customerId;
		this.quantity = quantity;
	}
	public Cart(Integer customerId, Integer productId, Integer quantity) {
		super();
		this.customerId = customerId;
		this.quantity = quantity;
	}
	public Cart() {
		super();
	}
}
