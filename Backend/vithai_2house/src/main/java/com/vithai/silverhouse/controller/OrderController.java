package com.vithai.silverhouse.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.vithai.silverhouse.entity.Order;
import com.vithai.silverhouse.service.OrderService;
import org.springframework.http.ResponseEntity;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService service;
    public OrderController(OrderService service) 
    {
    	this.service = service; 
    }

    @GetMapping
    public List<Order> all() 
    {
    	return service.getAll();
    }

    @PostMapping
    public ResponseEntity<?> place(@RequestBody PlaceOrderRequest req) 
    {
        Order o = service.placeOrder(
        		req.getCustomerName(),
        		req.getCustomerEmail(), 
        		req.getCustomerPhone(),
        		req.getCustomerAddress()
        		);
        if (o == null)
        	return ResponseEntity.badRequest()
        			.body("Cart is empty");
        return ResponseEntity.ok(o);
    }
    
    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id) 
    {
    	service.remove(id); 
    }

    public static class PlaceOrderRequest {
        private String customerName;
        private String customerEmail;
        private String customerPhone;
        private String customerAddress;
        // getters/setters
        public String getCustomerName()
        {
        	return customerName;
        } 
        public void setCustomerName(String s)
        {
        	this.customerName=s;
        }
        public String getCustomerEmail()
        {
        	return customerEmail;
        }
        public void setCustomerEmail(String s)
        {
        	this.customerEmail=s;
        }
        public String getCustomerPhone()
        {
        	return customerPhone;
        } 
        public void setCustomerPhone(String s)
        {
        	this.customerPhone=s;
        }
        public String getCustomerAddress()
        {
        	return customerAddress;
        }
        public void setCustomerAddress(String s)
        {
        	this.customerAddress=s;
        }
    }
}
