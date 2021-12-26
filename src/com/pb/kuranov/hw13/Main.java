package com.pb.kuranov.hw13;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        LinkedList<Integer> buffer = new LinkedList<>();
        Thread producer = new Thread(new Producer(buffer));
        producer.setName("Производитель");
        Thread consumer = new Thread(new Consumer(buffer));
        consumer.setName("Потребитель");
        producer.start();
        consumer.start();
    }
}
