package com.vithai.silverhouse.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "order_items")
public class OrderItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Product product;
    private int qty;
    private double price; 

    public OrderItem() {}
    public OrderItem(Product product, int qty, double price)
    {
        this.product = product; 
        this.qty = qty; 
        this.price = price;
    }

    // getters / setters
    public Long getId()
    {
    	return id;
    }
    public void setId(Long id) 
    {
    	this.id = id;
    }
    public Product getProduct()
    {
    	return product; 
    }
    public void setProduct(Product product) 
    {
    	this.product = product; 
    }
    public int getQty()
    {
    	return qty; 
    }
    public void setQty(int qty) 
    {
    	this.qty = qty; 
    }
    public double getPrice() 
    {
    	return price;
    }
    public void setPrice(double price) 
    {
    	this.price = price; 
    }
}
