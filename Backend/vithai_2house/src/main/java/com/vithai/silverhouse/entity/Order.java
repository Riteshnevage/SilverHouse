package com.vithai.silverhouse.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItem> items = new ArrayList<>();

    private double total;
    private String status = "Placed"; // Placed, Shipped, Out for Delivery, Delivered

    // simple customer fields
    private String customerName;
    private String customerEmail;
    private String customerPhone;
    private String customerAddress;
    
    // getters / setters
    public Long getId()
    { 
    	return id;
    }
    public void setId(Long id)
    { 
    	this.id = id;
    }
    public List<OrderItem> getItems()
    { 
    	return items;
    }
    public void setItems(List<OrderItem> items) 
    { 
    	this.items = items;
    }
    public double getTotal()
    {
    	return total;
    }
    public void setTotal(double total)
    { 
    	this.total = total;
    }
    public String getStatus()
    {
    	return status;
    }
    public void setStatus(String status)
    { 
    	this.status = status;
    }
    public String getCustomerName()
    {
    	return customerName;
    }
    public void setCustomerName(String customerName)
    { 
    	this.customerName = customerName; 
    }
    public String getCustomerEmail() 
    { 
    	return customerEmail;
    }
    public void setCustomerEmail(String customerEmail)
    { 
    	this.customerEmail = customerEmail;
    }
    public String getCustomerPhone() 
    { 
    	return customerPhone;
    }
    public void setCustomerPhone(String customerPhone) 
    {
    	this.customerPhone = customerPhone; 
    }
    public String getCustomerAddress()
    {
    	return customerAddress;
    }
    public void setCustomerAddress(String customerAddress)
    {
    	this.customerAddress = customerAddress; 
    }
}

