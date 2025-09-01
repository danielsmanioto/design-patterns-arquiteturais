package com.danielsmanioto.ds_resilience_circuit_breaker.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/api/teste")
    @CircuitBreaker(name = "meuCircuitBreaker", fallbackMethod = "fallback")
    public ResponseEntity<String> teste() {
        if (Math.random() < 0.7) {
            throw new RuntimeException("Falha simulada!");
        }
        return ResponseEntity.ok("Sucesso!");
    }

    public ResponseEntity<String> fallback(Throwable ex) {
        System.out.println("Fallback chamado! Erro: " + ex.getMessage());
        return ResponseEntity.status(503).body("Circuit Breaker ativado! Resposta alternativa.");
    }
}