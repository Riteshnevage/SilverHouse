package com.vithai.silverhouse.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(length = 1200)
    private String desc;
    private Double price;
    private String img;

    // Constructors
    public Product() {}
    public Product(String name, String desc, Double price, String img)
    {
        this.img = img;
        this.price = price;
        this.desc = desc;
        this.name = name;
    }

    // Getters / Setters
    public Long getId() 
    {
    	return id;
    }
    public void setId(Long id) 
    {
    	this.id = id; 
    }
    public String getName() 
    {
    	return name; 
    }
    public void setName(String name) 
    {
    	this.name = name; 
    }
    public String getDesc( ) 
    {
    	return desc; 
    }
    public void setDesc(String desc) 
    {
    	this.desc = desc;
    }
    public Double getPrice() 
    {
    	return price;
    }
    public void setPrice(Double price) 
    {
    	this.price = price; 
    }
    public String getImg()
    {
    	return img; 
    }
    public void setImg(String img) 
    {
    	this.img = img; 
    }
}

