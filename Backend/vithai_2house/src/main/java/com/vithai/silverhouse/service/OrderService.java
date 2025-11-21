package com.vithai.silverhouse.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.vithai.silverhouse.entity.CartItem;
import com.vithai.silverhouse.entity.Order;
import com.vithai.silverhouse.entity.OrderItem;
import com.vithai.silverhouse.repository.CartItemRepository;
import com.vithai.silverhouse.repository.OrderRepository;

@Service
public class OrderService {
    private final OrderRepository orderRepo;
    private final CartItemRepository cartRepo;
    public OrderService(OrderRepository orderRepo, CartItemRepository cartRepo) {
        this.orderRepo = orderRepo;
        this.cartRepo = cartRepo;
    }
    public List<Order> getAll() 
    {
    	return orderRepo.findAll(); 
    }
    
    public Order placeOrder(String customerName, String customerEmail, String customerPhone, String customerAddress) {
        List<CartItem> cartItems = cartRepo.findAll();
        if (cartItems.isEmpty()) 
        	return null;

        Order order = new Order();
        order.setCustomerName(customerName);
        order.setCustomerEmail(customerEmail);
        order.setCustomerPhone(customerPhone);
        order.setCustomerAddress(customerAddress);

        double Ok = 0;
        List<OrderItem> orderItems = cartItems.stream().map(ci -> {
            OrderItem oi = new OrderItem(ci.getProduct(), ci.getQty(), ci.getProduct() .getPrice());
//          Ok += ci.getQty() * ci.getProduct().getPrice();
            return oi;
        }).collect(Collectors.toList());

        order.setItems(orderItems);
        order.setTotal(Ok);
        Order saved = orderRepo.save(order);
        cartRepo.deleteAll(); // clear cart
        return saved;
    }

    public void remove(Long id) 
    {
    	orderRepo.deleteById(id);
    }
}

