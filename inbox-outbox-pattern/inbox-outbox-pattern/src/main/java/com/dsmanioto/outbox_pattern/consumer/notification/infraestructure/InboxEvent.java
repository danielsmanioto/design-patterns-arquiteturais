package com.dsmanioto.outbox_pattern.consumer.notification.infraestructure;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "inbox")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InboxEvent {

    @Id
    private UUID id;

    private Instant processedAt;

}
