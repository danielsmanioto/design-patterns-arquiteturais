package com.dsmanioto.outbox_pattern.producer.order.service;

import com.dsmanioto.outbox_pattern.producer.order.domain.Order;
import com.dsmanioto.outbox_pattern.producer.order.domain.OrderRepository;
import com.dsmanioto.outbox_pattern.producer.order.infraestructure.OutboxEvent;
import com.dsmanioto.outbox_pattern.producer.order.infraestructure.OutboxRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {

    private final OrderRepository orderRepo;
    private final OutboxRepository outboxRepo;
    private final ObjectMapper mapper = new ObjectMapper();

    public OrderService(OrderRepository orderRepo,
                        OutboxRepository outboxRepo) {
        this.orderRepo = orderRepo;
        this.outboxRepo = outboxRepo;
    }

    @Transactional
    public Order create(String customer) throws Exception {

        Order order = new Order(customer);
        orderRepo.save(order);

        String payload = mapper.writeValueAsString(order);

        OutboxEvent event = new OutboxEvent(
                UUID.randomUUID(),
                "Order",
                order.getId(),
                "OrderCreated",
                payload,
                false
        );

        outboxRepo.save(event);
        return order;
    }
}
