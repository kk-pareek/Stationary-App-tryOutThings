package com.tavant.stationary_shop.customer.service;

import com.tavant.stationary_shop.customer.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getCustomers();
    Customer createCustomer(Customer customer);
    Customer getCustomerById(Long customerId);
    Customer updateCustomerById(Long customerId, Customer customer);
    Customer deleteCustomerById(Long customerId);
}
