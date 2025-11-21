package com.vithai.silverhouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vithai.silverhouse.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    boolean existsByEmail(String email);
}

