package org.example;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;

public class Main {
    private static final String ZK_ADDRESS = "localhost:2181";
    private static final String LOCK_PATH = "/meu-lock-distribuido";

    public static void main(String[] args) {
        System.out.println("Hello world!");

        CuratorFramework client = CuratorFrameworkFactory.newClient(
                ZK_ADDRESS,
                new ExponentialBackoffRetry(1000, 3)
        );
        client.start();

        // Simulando duas threads que tentam pegar o mesmo lock
        Runnable task = () -> {
            InterProcessMutex lock = new InterProcessMutex(client, LOCK_PATH);
            String threadName = Thread.currentThread().getName();

            try {
                if (lock.acquire(5, java.util.concurrent.TimeUnit.SECONDS)) {
                    System.out.println(threadName + " ➤ Lock adquirido, executando operação crítica...");
                    Thread.sleep(3000); // Simula algo demorado
                    lock.release();
                    System.out.println(threadName + " ➤ Lock liberado.");
                } else {
                    System.out.println(threadName + " ❌ Não conseguiu adquirir o lock.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        // Simula 10 locks
        for (int i =1; i<=10; i++) {
            new Thread(task, "Instância-" + i).start();
        }
    }

}