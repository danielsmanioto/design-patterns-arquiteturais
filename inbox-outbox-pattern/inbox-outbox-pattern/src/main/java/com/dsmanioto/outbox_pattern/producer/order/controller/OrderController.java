package com.dsmanioto.outbox_pattern.producer.order.controller;

import com.dsmanioto.outbox_pattern.producer.order.domain.Order;
import com.dsmanioto.outbox_pattern.producer.order.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public Order create(@RequestParam String customer) throws Exception {
        return service.create(customer);
    }
}
