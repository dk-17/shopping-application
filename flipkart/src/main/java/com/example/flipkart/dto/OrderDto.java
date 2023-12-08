package com.example.flipkart.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class OrderDto {
    private Integer id;
    private Integer customerId;
    private String customerName;
    private String item;
    private Integer quantity;
    private String paymentMethod;
    private String orderDate;
}

