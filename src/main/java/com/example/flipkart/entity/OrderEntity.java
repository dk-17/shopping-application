package com.example.flipkart.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class OrderEntity {
    private Integer id;
    private Integer customerId;
    private String customerName;
    private String item;
    private Integer quantity;
    private String paymentMethod;
    private String orderDate;
}
