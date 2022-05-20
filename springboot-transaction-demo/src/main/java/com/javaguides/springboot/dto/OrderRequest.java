package com.javaguides.springboot.dto;

import com.javaguides.springboot.entity.Order;
import com.javaguides.springboot.entity.Payment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {
    private Order order;
    private Payment payment;
}
