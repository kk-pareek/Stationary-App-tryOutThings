package com.example.app.customer.controllers;

import com.example.app.customer.entities.Customer;
import com.example.app.customer.exceptions.CustomerNotFoundException;
import com.example.app.customer.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    private Object Optional;

    @GetMapping("customers")
    public Iterable<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("customers/{customerId}")
    public Optional<Customer> getCustomerById(@PathVariable Integer customerId) {
        return customerService.getCustomerById(customerId);
    }

    @PostMapping("customers")
    public void addCustomer(@RequestBody Customer theCustomer) {
        customerService.addCustomer(theCustomer);
    }

    @PutMapping("customers/{customerId}")
    public void updateCustomerById(@RequestBody Customer theCustomer, @PathVariable Integer customerId) {
        customerService.updateCustomerById(theCustomer, customerId);
    }

    @DeleteMapping("customers/{customerId}")
    public void deleteCustomerById(@PathVariable Integer customerId) {
        customerService.deleteCustomerById(customerId);
    }
}
