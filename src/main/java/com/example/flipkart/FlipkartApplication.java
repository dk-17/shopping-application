package com.example.flipkart;

import com.example.flipkart.dto.InventoryDto;
import com.example.flipkart.dto.OrderDto;
import com.example.flipkart.dto.UserDto;
import com.example.flipkart.exception.ItemNotFoundException;
import com.example.flipkart.repository.InventoryRepository;
import com.example.flipkart.repository.OrderRepository;
import com.example.flipkart.repository.UserRepository;
import com.example.flipkart.service.InventoryService;
import com.example.flipkart.service.OrderService;
import com.example.flipkart.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class FlipkartApplication {

	public static void main(String[] args) {
	    // create in-memory storage
		InventoryRepository inventoryRepository = new InventoryRepository();
		UserRepository userRepository = new UserRepository();
		OrderRepository orderRepository = new OrderRepository();


		InventoryDto inventory1 = new InventoryDto(1,"Shoes", 5, 200);
		InventoryDto inventory2 = new InventoryDto(2,"Watch", 10, 1000);
		InventoryDto inventory3 = new InventoryDto(3,"T-Shirt", 14, 300);

		InventoryService inventoryService = new InventoryService(inventoryRepository);

		inventoryService.seedInventory(inventory1);
		inventoryService.seedInventory(inventory2);
		inventoryService.seedInventory(inventory3);

		inventoryService.viewInventory();

		UserService userService = new UserService(userRepository);

		UserDto user1 = new UserDto(1, "Akshay", 5000);

		userService.registerUser(user1);

		OrderService orderService = new OrderService(orderRepository, inventoryRepository, userRepository);

		OrderDto orderDto = new OrderDto(1, user1.getId(), user1.getName(), "Shoes",2, "BNPL", "20-Oct-2021");

		try {
			orderService.takeOrder(orderDto);
		} catch (ItemNotFoundException e) {
			log.error("Exception occur while order id:{}", orderDto.getId());
		}

		inventoryService.viewInventory();
	}

}
