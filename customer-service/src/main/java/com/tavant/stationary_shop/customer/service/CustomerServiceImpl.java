package com.tavant.stationary_shop.customer.service;

import com.tavant.stationary_shop.customer.exception.CustomerNotFoundException;
import com.tavant.stationary_shop.customer.model.Customer;
import com.tavant.stationary_shop.customer.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepo customerRepo;

    @Autowired
    public CustomerServiceImpl(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public List<Customer> getCustomers() {
        return customerRepo.findAll();
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    public Customer getCustomerById(Long customerId) {
        Optional<Customer> customer = customerRepo.findById(customerId);

        if(customer.isPresent()){
            return customer.get();
        }
        else {
            throw new CustomerNotFoundException("Customer with given id:"+customerId+" not found");
        }
    }

    @Override
    public Customer updateCustomerById(Long customerId, Customer customer) {
        Customer existingCustomer = getCustomerById(customerId);

        existingCustomer.setCustomerName(customer.getCustomerName());
        existingCustomer.setPhoneNo(customer.getPhoneNo());
        existingCustomer.setEmail(customer.getEmail());

        return customerRepo.save(existingCustomer);
    }

    @Override
    public Customer deleteCustomerById(Long customerId) {
        Customer customer = getCustomerById(customerId);
        customerRepo.delete(customer);
        return customer;
    }
}
