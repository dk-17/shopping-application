package com.example.flipkart.repository;

import com.example.flipkart.dto.OrderDto;
import com.example.flipkart.entity.OrderEntity;

import java.util.HashMap;

public class OrderRepository {
    HashMap<String, OrderEntity> order = new HashMap<>();

    public void addOrder(OrderDto orderDto) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(orderDto.getId());
        orderEntity.setCustomerId(orderDto.getCustomerId());
        orderEntity.setCustomerName(orderDto.getCustomerName());
        orderEntity.setItem(orderDto.getItem());
        orderEntity.setQuantity(orderDto.getQuantity());
        orderEntity.setPaymentMethod(orderEntity.getPaymentMethod());
        orderEntity.setOrderDate(orderDto.getOrderDate());

        order.put(orderDto.getCustomerName(), orderEntity);
    }
}
