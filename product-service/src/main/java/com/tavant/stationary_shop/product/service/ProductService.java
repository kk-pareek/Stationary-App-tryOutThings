package com.tavant.stationary_shop.product.service;

import com.tavant.stationary_shop.product.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();
    Product createProduct(Product product);
    Product getProductById(Long productId);
    Product updateProductById(Long productId, Product product);
    Product deleteProductById(Long productId);
}
