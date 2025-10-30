package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static void main(String[] args) {
        EventBus eventBus = new EventBus();

        Subscriber sub1 = new PrintSubscriber("Sub1");
        eventBus.subscribe("news", sub1);

        Subscriber sub2 = new PrintSubscriber("Sub2");
        eventBus.subscribe("news", sub2);
        eventBus.subscribe("sports", sub1);

        // Publicando mensagens nos tópicos
        eventBus.publish("news", "Nova notícia publicada!");
        eventBus.publish("sports", "Saiu o resultado do jogo!");
    }

}
