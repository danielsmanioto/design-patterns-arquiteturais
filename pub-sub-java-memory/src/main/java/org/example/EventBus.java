package org.example;

import java.util.*;

public class EventBus {
    private Map<String, List<Subscriber>> subscribers = new HashMap<>();

    public void subscribe(String topic, Subscriber subscriber) {
        subscribers.computeIfAbsent(topic, k -> new ArrayList<>()).add(subscriber);
    }

    public void publish(String topic, String message) {
        List<Subscriber> subs = subscribers.get(topic);
        if (subs != null) {
            for (Subscriber s : subs) {
                s.onMessage(topic, message);
            }
        }
    }
}