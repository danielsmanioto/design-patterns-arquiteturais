package com.dsmanioto.outbox_pattern.producer.order.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue
    private UUID id;

    private String customer;

    public Order(String customer) {
        this.customer = customer;
    }

}
