package com.vithai.silverhouse.service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.vithai.silverhouse.entity.CartItem;
import com.vithai.silverhouse.entity.Product;
import com.vithai.silverhouse.repository.CartItemRepository;
import com.vithai.silverhouse.repository.ProductRepository;

@Service
public class CartService {
    private final CartItemRepository cartRepo;
    private final ProductRepository productRepo;
    public CartService(CartItemRepository cartRepo, ProductRepository productRepo) {
        this.cartRepo = cartRepo;
        this.productRepo = productRepo;
    }
    
    public List<CartItem> getAll() 
    {
    	return cartRepo.findAll(); 
    }

    public CartItem addToCart(Long productId, int qty) 
    {
        Product p = productRepo.findById(productId).orElse(null);
        if (p == null) 
        	return null;
        // simple approach: create new item (could merge duplicates)
        CartItem item = new CartItem(p, qty);
        return cartRepo.save(item);
    }
    
    public CartItem updateQty(Long cartItemId, int qty) 
    {
        return cartRepo.findById(cartItemId).map(ci ->
        {
            ci.setQty(qty);
            return cartRepo.save(ci);
        })
        	  .orElse(null);
    }

    public void remove(Long id) 
    {
    	cartRepo.deleteById(id); 
    }
    public void clear() 
    {
    	cartRepo.deleteAll(); 
    }
}

