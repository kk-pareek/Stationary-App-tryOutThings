package com.tavant.stationary_shop.customer.controller;

import com.tavant.stationary_shop.customer.model.Customer;
import com.tavant.stationary_shop.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customer")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<String> applicationStatus(){
        return new ResponseEntity<>("customer-service is up", HttpStatus.OK);
    }

    @GetMapping("customers")
    public ResponseEntity<List<Customer>> getCustomers(){
        return new ResponseEntity<>(customerService.getCustomers(), HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        return new ResponseEntity<>(customerService.createCustomer(customer), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Long customerId){
        return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.FOUND);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") Long customerId, @RequestBody Customer customer){
        return new ResponseEntity<>(customerService.updateCustomerById(customerId, customer),HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Customer> deleteCustomerById(@PathVariable("id") Long customerId){
        return new ResponseEntity<>(customerService.deleteCustomerById(customerId), HttpStatus.OK);
    }
}
