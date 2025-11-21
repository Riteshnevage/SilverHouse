package com.vithai.silverhouse.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cart_items")
public class CartItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Product product;

    private int qty = 1;

    public CartItem() {}
    public CartItem(Product product, int qty) {
        this.product = product; 
        this.qty = qty;
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
}
