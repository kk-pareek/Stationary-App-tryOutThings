package com.tavant.stationary_shop.product.controller;

import com.tavant.stationary_shop.product.model.Product;
import com.tavant.stationary_shop.product.repository.ProductRepo;
import com.tavant.stationary_shop.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<String> applicationStatus(){
        return new ResponseEntity<>("product is up", HttpStatus.OK);
    }

    @GetMapping("products")
    public ResponseEntity<List<Product>> getProducts(){
        return new ResponseEntity<>(productService.getProducts(),HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.createProduct(product), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Integer productId){
        return new ResponseEntity<>(productService.getProductById(productId), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> updateProductById(@PathVariable("id") Integer productId,
                                                 @RequestBody Product product){
        return new ResponseEntity<>(productService.updateProductById(productId, product), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Product> deleteProductById(@PathVariable("id") Integer productId){
        return new ResponseEntity<>(productService.deleteProductById(productId), HttpStatus.OK);
    }


}
