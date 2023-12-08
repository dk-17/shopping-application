package com.example.flipkart.service;

import com.example.flipkart.dto.InventoryDto;
import com.example.flipkart.entity.InventoryEntity;
import com.example.flipkart.repository.InventoryRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class InventoryService {
    private InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public void seedInventory(InventoryDto inventoryDto) {
        inventoryRepository.addInventory(inventoryDto);
        log.info("{} inventory added successfully with quantity {} at price {}",
                inventoryDto.getName(), inventoryDto.getQuantity(), inventoryDto.getPrice());
    }

    public void viewInventory() {
        List<InventoryEntity> inventoryList = inventoryRepository.getInventory();
        for (InventoryEntity entity : inventoryList) {
            log.info("{}. Item: {}, quantity: {}, price: {}",entity.getId(), entity.getName(), entity.getQuantity(), entity.getPrice());
        }
    }

}
