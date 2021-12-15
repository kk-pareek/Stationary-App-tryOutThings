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
import javax.persistence.Table;


@Entity
@Table(name="cart")
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cartId;
	
	@Column
	private Integer customerId;
	
    @OneToMany(targetEntity = Product.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_product_fk", referencedColumnName = "cartId")
    private List<Product> products;
	
	public Cart(Integer cartId, Integer customerId, List<Product> products) {
		super();
		this.cartId = cartId;
		this.customerId = customerId;
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


	public Cart(Integer cartId, Integer customerId, Integer productId, Integer quantity) {
		super();
		this.cartId = cartId;
		this.customerId = customerId;
	}
	public Cart(Integer customerId, Integer productId, Integer quantity) {
		super();
		this.customerId = customerId;
	}
	public Cart() {
		super();
	}
}
