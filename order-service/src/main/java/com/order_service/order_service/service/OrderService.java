package com.order_service.order_service.service;


import com.order_service.order_service.dto.Order;

import java.util.List;

public interface OrderService {

    void placeOrder(Order order);

    List<Order> getAllOrders();

}
