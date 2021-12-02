package com.training.springstationary.controller;

import com.training.springstationary.entity.product;
import com.training.springstationary.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/product")
public class productController
{
    @Autowired
    productService service;

    @PostMapping("/addProduct")
    void addNewProduct(@RequestBody product product)
    {
        service.addNewProduct(product);
    }

    @GetMapping("/allProducts")
    Iterable<product> allProducts()
    {
        return service.getAllProducts();
    }

    @GetMapping("/product/{id}")
    Optional<product> getProductById(@PathVariable Integer id)
    {
        return service.getProductById(id);
    }

    @PutMapping("/update/{id}")
    void updateProductById(@PathVariable Integer id, @RequestBody product product)
    {
        service.updateProductById(id, product);
    }

    @DeleteMapping("/delete/{id}")
    void deleteProductById(@PathVariable Integer id)
    {
        service.deleteProductById(id);
    }
}
