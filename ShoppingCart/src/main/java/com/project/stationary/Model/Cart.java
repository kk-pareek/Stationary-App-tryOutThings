package com.project.stationary.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cartId;
	
	@Column(unique = true)
	private Integer customerId;
	
	@Column(unique = true)
	private Integer productId;
	
	@Column
	private Integer quantity;
	
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
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
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
		this.productId = productId;
		this.quantity = quantity;
	}
	public Cart(Integer customerId, Integer productId, Integer quantity) {
		super();
		this.customerId = customerId;
		this.productId = productId;
		this.quantity = quantity;
	}
	public Cart() {
		super();
	}
}
