package com.dsmanioto.outbox_pattern.consumer.notification.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notification {

    @Id
    private UUID id;

    private UUID orderId;
    private String message;
    private Instant createdAt;
}
