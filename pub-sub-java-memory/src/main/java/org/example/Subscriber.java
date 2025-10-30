package org.example;

public interface Subscriber {

    void onMessage(String topic, String message);

}
