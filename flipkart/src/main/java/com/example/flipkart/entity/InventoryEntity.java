package com.example.flipkart.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InventoryEntity {
    private Integer id;
    private Integer quantity;
    private String name;
    private Integer price;
}
