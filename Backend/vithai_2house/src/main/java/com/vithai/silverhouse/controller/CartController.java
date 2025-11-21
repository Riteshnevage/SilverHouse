package com.vithai.silverhouse.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.vithai.silverhouse.entity.CartItem;
import com.vithai.silverhouse.service.CartService;
import org.springframework.http.ResponseEntity;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/cart")
public class CartController {
    private final CartService service;
    public CartController(CartService service) 
    {
    	this.service = service; 
    }

    @GetMapping
    public List<CartItem> all()
    {
    	return service.getAll();
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody CartAddRequest req) 
    {
        CartItem added = service.addToCart(req.getProductId(), req.getQty());
        if (added == null)
        	return ResponseEntity.badRequest().body("Product not found");
        return ResponseEntity.ok(added);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateQty(@PathVariable Long id, @RequestBody UpdateQtyRequest r)
    {
        CartItem ci = service.updateQty(id, r.getQty());
        if (ci == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(ci);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id) 
    {
    	service.remove(id);
    }

    @DeleteMapping
    public void clear() 
    {
    	service.clear();
    }

    // DTOs
    static class CartAddRequest 
    {
    	private Long productId; 
    	private int qty = 1;
        public Long getProductId() 
        {
        	return productId; 
        }
        public void setProductId(Long productId) 
        {
        	this.productId = productId; 
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
    static class UpdateQtyRequest 
    {
    	private int qty; 
    	public int getQty()
    	{
    		return qty;
    	} 
    	public void setQty(int qty)
    	{
    		this.qty=qty;
    	}
    	}
}








