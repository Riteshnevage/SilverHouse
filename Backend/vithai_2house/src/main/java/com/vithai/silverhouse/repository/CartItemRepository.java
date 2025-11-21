package com.vithai.silverhouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vithai.silverhouse.entity.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {}

