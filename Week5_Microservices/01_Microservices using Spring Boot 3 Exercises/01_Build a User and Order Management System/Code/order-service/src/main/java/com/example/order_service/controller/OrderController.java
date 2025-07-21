package com.example.order_service.controller;

import com.example.order_service.entity.Order;
import com.example.order_service.response.OrderResponse;
import com.example.order_service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public Order placeOrder(@RequestBody Order order) {
        return orderService.placeOrder(order);
    }

    @GetMapping("/{id}")
    public OrderResponse getOrderWithUser(@PathVariable Long id) {
        return orderService.getOrderWithUser(id);
    }
}
