package com.training.springstationary.service;

import com.training.springstationary.entity.product;
import com.training.springstationary.repository.productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.Optional;

@Service
public class productService
{
    @Autowired
    productRepository repository;

    public void addNewProduct(product product)
    {
        repository.save(product);
    }

    public Iterable<product> getAllProducts()
    {
        return repository.findAll();
    }

    public Optional<product> getProductById(Integer id)
    {
        return repository.findById(id);
    }

    public void updateProductById(Integer id, product product)
    {
        repository.save(product);
    }

    public void deleteProductById(Integer id)
    {
        repository.deleteById(id);
    }

}
