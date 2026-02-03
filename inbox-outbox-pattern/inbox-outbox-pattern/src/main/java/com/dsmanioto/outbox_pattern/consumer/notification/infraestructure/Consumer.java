package com.dsmanioto.outbox_pattern.consumer.notification.infraestructure;

import com.dsmanioto.outbox_pattern.consumer.notification.service.NotificationService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.UUID;

@Component
public class Consumer {

    private final InboxRepository inboxRepo;
    private final NotificationService service;
    private final ObjectMapper mapper = new ObjectMapper();

    public Consumer(InboxRepository inboxRepo,
                    NotificationService service) {
        this.inboxRepo = inboxRepo;
        this.service = service;
    }

    @KafkaListener(topics = "order-events", groupId = "app")
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
