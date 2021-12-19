package com.pb.kuranov.hw10;

public class Main {
    public static void main(String[] args) {

    NumBox<Integer> i = new NumBox<>(4);

    try {
    i.add(1);
    i.add(5);
    i.add(4);
    i.add(3);
    } catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("Ошибка!Размер массива не позволяет добавить следующий элемент!");
    }

    System.out.println("Элемент массива номер 1 равен: " + i.get(0));
    System.out.println("Сумма массива равна: " + i.sum());
    System.out.println("Длина текущего массива равна: " + i.length());
    System.out.println("Среднее значение массива равно: " + i.average());
    System.out.println("Максимальное значение массива равно: " + i.max());
    System.out.println();

    NumBox<Float> d = new NumBox<>(4);

    try {
    d.add(2.5f);
    d.add(5.9f);
    d.add(4.3f);
    d.add(1.7f);
    } catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("Ошибка!Размер массива не позволяет добавить следующий элемент!");
    }

    System.out.println("Элемент массива номер 1 равен: " + d.get(0));
    System.out.println("Сумма массива равна: " + d.sum());
    System.out.println("Длина текущего массива равна: " + d.length());
    System.out.println("Среднее значение массива равно: " + d.average());
    System.out.println("Максимальное значение массива равно: " + d.max());
    }
}
