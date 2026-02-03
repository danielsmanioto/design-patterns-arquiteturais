package com.dsmanioto.outbox_pattern.consumer.notification.service;

import com.dsmanioto.outbox_pattern.consumer.notification.domain.Notification;
import com.dsmanioto.outbox_pattern.consumer.notification.domain.NotificationRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.UUID;

@Service
public class NotificationService {

    private final NotificationRepository repo;
    private final ObjectMapper mapper = new ObjectMapper();

    public NotificationService(NotificationRepository repo) {
        this.repo = repo;
    }

    @Transactional
    public void process(String payload) throws Exception {

        JsonNode json = mapper.readTree(payload);
        UUID orderId = UUID.fromString(json.get("id").asText());

        Notification notification = new Notification(
                UUID.randomUUID(),
                orderId,
                "Pedido criado com sucesso!",
                Instant.now()
        );

        repo.save(notification);
    }
}

