package com.danielsmanioto.webhook_sprinboot;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/webhook")
public class WebhookController {

    @PostMapping
    public ResponseEntity<String> receiveWebhook(@RequestBody String payload) {
        System.out.println("Recebido Webhook! Payload: " + payload);
        return ResponseEntity.ok("Recebido com sucesso!");
    }

}