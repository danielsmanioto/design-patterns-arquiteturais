package com.dsmanioto.outbox_pattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class OutboxPatternApplication {

	public static void main(String[] args) {
		SpringApplication.run(OutboxPatternApplication.class, args);
	}

}
