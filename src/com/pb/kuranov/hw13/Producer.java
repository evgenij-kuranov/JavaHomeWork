package com.pb.kuranov.hw13;

import java.util.LinkedList;
import java.util.Random;

public class Producer implements Runnable {

    private final LinkedList<Integer> buffer;

    public Producer(LinkedList<Integer> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        Random random = new Random();
        while (true) {
            synchronized (buffer) {
                try {
                    while (!buffer.isEmpty()) {
                        buffer.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    }
                System.out.println(name + " стартовал...");
                for (int x = 0; x < 5; x++) {
                    buffer.add(random.nextInt(100));
                    System.out.println(buffer);
                }
                System.out.println("Буфер заполнен!");
                buffer.notify();
            }
        }
    }
}
