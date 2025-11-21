package com.vithai.silverhouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.vithai.silverhouse.repository.ProductRepository;
import com.vithai.silverhouse.repository.OrderRepository;
import com.vithai.silverhouse.repository.CustomerRepository;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*")
public class AdminController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/dashboard")
    public Map<String, Object> getDashboardStats() {
        Map<String, Object> stats = new HashMap<>();
        stats.put("totalProducts", productRepository.count());
        stats.put("totalOrders", orderRepository.count());
        stats.put("totalCustomers", customerRepository.count());
        stats.put("totalRevenue", orderRepository.getTotalRevenue());
        return stats;
    }
}
