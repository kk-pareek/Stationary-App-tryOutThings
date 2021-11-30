package com.tavant.stationary_shop.product.service;

import com.tavant.stationary_shop.product.exception.ProductNotFoundException;
import com.tavant.stationary_shop.product.model.Product;
import com.tavant.stationary_shop.product.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepo productRepo;

    @Autowired
    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public List<Product> getProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product createProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product getProductById(Long productId) {
       Optional<Product> product = productRepo.findById(productId);

       if (product.isPresent()){
           return product.get();
       }else {
           throw new ProductNotFoundException("product with id:"+productId+" not found");
       }
    }

    @Override
    public Product updateProductById(Long productId, Product product) {
        Product existingProduct = getProductById(productId);

        existingProduct.setProductName(product.getProductName());
        existingProduct.setProductPrice(product.getProductPrice());

        return productRepo.save(existingProduct);
    }

    @Override
    public Product deleteProductById(Long productId) {
        Product product = getProductById(productId);
        productRepo.delete(product);
        return product;
    }
}
