package com.example.order_service.response;

import com.example.order_service.entity.Order;
import com.example.order_service.dto.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private Order order;
    private User user;
}
