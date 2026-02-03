package com.dsmanioto.outbox_pattern.consumer.notification.service;

import com.dsmanioto.outbox_pattern.consumer.notification.infraestructure.InboxEvent;
import com.dsmanioto.outbox_pattern.consumer.notification.infraestructure.InboxRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.UUID;

@Component
public class OrderEventConsumer {

    private final InboxRepository inboxRepo;
    private final NotificationService service;
    private final ObjectMapper mapper = new ObjectMapper();

    public OrderEventConsumer(InboxRepository inboxRepo,
                              NotificationService service) {
        this.inboxRepo = inboxRepo;
        this.service = service;
    }

    @KafkaListener(topics = "order-events", groupId = "notification-service")
    @Transactional
    public void consume(String payload) throws Exception {

        JsonNode json = mapper.readTree(payload);
        UUID eventId = UUID.fromString(json.get("id").asText());

        if (inboxRepo.existsById(eventId))
            return; // idempotência

        inboxRepo.save(new InboxEvent(eventId, Instant.now()));
        service.process(payload);
    }
}
