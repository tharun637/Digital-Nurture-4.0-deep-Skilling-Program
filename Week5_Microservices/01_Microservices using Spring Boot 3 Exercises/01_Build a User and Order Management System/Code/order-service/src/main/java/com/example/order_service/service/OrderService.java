package com.example.order_service.service;

import com.example.order_service.entity.Order;
import com.example.order_service.feign.UserClient;
import com.example.order_service.repository.OrderRepository;
import com.example.order_service.response.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserClient userClient;

    public Order placeOrder(Order order) {
        return orderRepository.save(order);
    }

    public OrderResponse getOrderWithUser(Long orderId) {
        Order order = orderRepository.findById(orderId).orElse(null);
        if (order == null) return null;

        var user = userClient.getUser(order.getUserId());
        return new OrderResponse(order, user);
    }
}
