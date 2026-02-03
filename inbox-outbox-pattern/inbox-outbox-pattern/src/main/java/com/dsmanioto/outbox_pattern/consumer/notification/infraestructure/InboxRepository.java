package com.dsmanioto.outbox_pattern.consumer.notification.infraestructure;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface InboxRepository extends JpaRepository<InboxEvent, UUID> {}
