package org.example;

public class PrintSubscriber implements Subscriber {
    private String name;

    public PrintSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void onMessage(String topic, String message) {
        System.out.println("[" + name + "] Recebeu no tópico '" + topic + "': " + message);
    }
}
