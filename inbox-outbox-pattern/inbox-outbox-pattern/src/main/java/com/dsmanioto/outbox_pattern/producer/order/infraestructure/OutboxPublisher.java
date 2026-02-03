package com.dsmanioto.outbox_pattern.producer.order.infraestructure;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class OutboxPublisher {

    private final OutboxRepository repo;
    private final KafkaTemplate<String, String> kafka;

    public OutboxPublisher(OutboxRepository repo,
                           KafkaTemplate<String, String> kafka) {
        this.repo = repo;
        this.kafka = kafka;
    }

    @Scheduled(fixedDelay = 3000)
    public void publish() {

        repo.findByPublishedFalse().forEach(event -> {
            kafka.send("order-events", event.getPayload());
            event.setPublished(true);
            repo.save(event);
        });
    }
}
