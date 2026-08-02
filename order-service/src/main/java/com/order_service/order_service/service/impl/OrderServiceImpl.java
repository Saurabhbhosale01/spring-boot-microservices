package com.order_service.order_service.service.impl;

import com.order_service.order_service.clients.InventryClient;
import com.order_service.order_service.dto.Order;
import com.order_service.order_service.entity.OrderEntity;
import com.order_service.order_service.entity.OrderPlacedEvent;
import com.order_service.order_service.repository.OrderRepository;
import com.order_service.order_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final InventryClient inventryClient;

    private final KafkaTemplate<String, OrderPlacedEvent> kafkaTemplate;

    @Override
    public void placeOrder(Order order) {
//        inventryClient.inStock();
        OrderEntity entity=OrderEntity.toEntity(order);
        orderRepository.save(entity);

        //sending the message to kafka topic we are sending ordernumnber and email
        OrderPlacedEvent orderPlacedEvent =new OrderPlacedEvent(order.getOrderNumber(),order.getPrice());
        log.info("sending message {} to kafka topic",orderPlacedEvent);
        kafkaTemplate.send("order-placed",orderPlacedEvent);
        log.info(" message {} is sent mto kafka topic",orderPlacedEvent);


    }

    @Override
    public List<Order> getAllOrders() {
        List<OrderEntity> orderss= orderRepository.findAll();
       return orderss.stream()
               .map(orderss::toDto)
               .toList();


    }
}
