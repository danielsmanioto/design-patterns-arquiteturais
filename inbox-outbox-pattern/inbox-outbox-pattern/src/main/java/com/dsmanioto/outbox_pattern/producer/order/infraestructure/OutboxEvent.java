package com.dsmanioto.outbox_pattern.producer.order.infraestructure;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "outbox")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OutboxEvent {

    @Id
    private UUID id;

    @Column(name = "aggregate_type", length = 100, nullable = false)
    private String aggregateType;

    @Column(name = "aggregate_id", nullable = false)
    private UUID aggregateId;

    @Column(name = "type", length = 100, nullable = false)
    private String type;

    @Column(nullable = false)
    private String payload;

    @Column(nullable = false)
    private boolean published;
}
