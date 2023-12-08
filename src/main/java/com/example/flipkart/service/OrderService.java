package com.example.flipkart.service;

import com.example.flipkart.dto.OrderDto;
import com.example.flipkart.dto.UserDto;
import com.example.flipkart.entity.InventoryEntity;
import com.example.flipkart.entity.OrderEntity;
import com.example.flipkart.exception.ItemNotFoundException;
import com.example.flipkart.repository.InventoryRepository;
import com.example.flipkart.repository.OrderRepository;
import com.example.flipkart.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class OrderService {
    private OrderRepository orderRepository;
    private InventoryRepository inventoryRepository;
    private UserRepository userRepository;

    public OrderService(OrderRepository orderRepository, InventoryRepository inventoryRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.inventoryRepository = inventoryRepository;
        this.userRepository = userRepository;
    }

    public void takeOrder(OrderDto orderDto) {
        ;
        String orderItem = orderDto.getItem();
        Integer orderQuantity = orderDto.getQuantity();

        InventoryEntity inventory = inventoryRepository.getInventoryByItem(orderItem);

        if (inventory == null) {
            throw new ItemNotFoundException("Item not found in the inventory: " + orderItem);
        }

        updateInventoryQuantity(orderQuantity, inventory);

        orderRepository.addOrder(orderDto);
        log.info("{} added order successfully.", orderDto.getCustomerName());
    }

    private void updateInventoryQuantity(Integer orderQuantity, InventoryEntity inventory) {
        Integer itemQuantity = inventory.getQuantity() - orderQuantity;
        inventory.setQuantity(itemQuantity);
    }

}
