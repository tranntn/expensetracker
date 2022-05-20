package com.javaguides.springboot.service;

import com.javaguides.springboot.dto.OrderRequest;
import com.javaguides.springboot.dto.OrderResponse;

public interface OrderService {
    OrderResponse placeOrder(OrderRequest orderRequest);
}
