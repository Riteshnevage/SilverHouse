package com.vithai.silverhouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vithai.silverhouse.entity.Customer;
import com.vithai.silverhouse.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer registerCustomer(Customer customer) {
        // Check if email already exists
        if (customerRepository.existsByEmail(customer.getEmail())) {
            throw new RuntimeException("❌ Email already exists! Please use a different one.");
        }
        
        // Save new customer
        return customerRepository.save(customer);
    }
}

