package com.example.app.customer.services;

import com.example.app.customer.entities.Customer;
import com.example.app.customer.exceptions.CustomerNotFoundException;
import com.example.app.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Iterable<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public void addCustomer(Customer theCustomer) {
        customerRepository.save(theCustomer);
    }

    public Optional<Customer> getCustomerById(Integer customerId) {
        Optional<Customer> theCustomer = customerRepository.findById(customerId);
        if(theCustomer.isPresent())
            return theCustomer;
        else
            throw new CustomerNotFoundException("Customer with id: '"+customerId+"' does not exist.");
    }

    public void updateCustomerById(Customer theCustomer, Integer customerId) {
        Customer existingCustomer = getCustomerById(customerId).get();
        existingCustomer.setCustomerEmail(theCustomer.getCustomerEmail());
        existingCustomer.setCustomerName(theCustomer.getCustomerName());
        customerRepository.save(existingCustomer);
    }

    public void deleteCustomerById(Integer customerId) {
        customerRepository.deleteById(customerId);
    }
}
