package com.pb.kuranov.hw13;

import java.util.LinkedList;

public class Consumer implements Runnable {

    private final LinkedList<Integer> buffer;

    public Consumer(LinkedList<Integer> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        while (true) {
            synchronized (buffer) {
                try {
                    while (buffer.isEmpty()) {
                        buffer.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(name + " стартовал...");
                for (int x = 0; x < 5; x++) {
                    System.out.println(buffer);
                    buffer.removeFirst();
                }
                System.out.println("Буфер пуст!");
                buffer.notify();
            }
        }
    }
}
