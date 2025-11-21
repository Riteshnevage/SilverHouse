package com.vithai.silverhouse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vithai.silverhouse.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>
{
	List<Product> findAll();
}
