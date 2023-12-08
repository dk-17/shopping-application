package com.example.flipkart.repository;

import com.example.flipkart.dto.InventoryDto;
import com.example.flipkart.entity.InventoryEntity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class InventoryRepository {
    HashMap<String, InventoryEntity> inventory = new HashMap<>();

    public void addInventory(InventoryDto inventoryDto) {
        InventoryEntity inventoryEntity = new InventoryEntity();

        inventoryEntity.setName(inventoryDto.getName());
        inventoryEntity.setQuantity(inventoryDto.getQuantity());
        inventoryEntity.setPrice(inventoryDto.getPrice());
        inventoryEntity.setId(inventoryDto.getId());
        //todo check for inventer id
        inventory.put(inventoryEntity.getName(), inventoryEntity);
    }
    public List<InventoryEntity> getInventory() {
        List<InventoryEntity> sortedInventory = new ArrayList<>(inventory.values());

        // Sort the list by ID in ascending order
        sortedInventory.sort(Comparator.comparingInt(InventoryEntity::getId));

        return sortedInventory;
    }

    public InventoryEntity getInventoryByItem(String item) {
        return inventory.get(item);
    }

}
