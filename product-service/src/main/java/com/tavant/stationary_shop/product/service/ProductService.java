package com.tavant.stationary_shop.product.service;

import com.tavant.stationary_shop.product.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();
    Product createProduct(Product product);
    Product getProductById(Integer productId);
    Product updateProductById(Integer productId, Product product);
    Product deleteProductById(Integer productId);
}
