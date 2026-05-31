package com.order_service.order_service.controller;

import com.order_service.order_service.clients.InventryClient;
import com.order_service.order_service.dto.Order;
import com.order_service.order_service.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/master/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    private final InventryClient inventryClient;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void placeOrder(@RequestBody Order order){
        var orderInStock=inventryClient.inStock(order.getSkuCode(),order.getQuantity());  //synchronous communication between order-service -> inventry-service

        if(orderInStock) orderService.placeOrder(order);

        else throw new RuntimeException("order is out of stock");
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Order> getAllOrders(){
        return  orderService.getAllOrders();
    }
}


