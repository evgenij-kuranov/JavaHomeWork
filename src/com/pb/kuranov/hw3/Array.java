package com.pb.kuranov.hw3;

import java.util.Arrays;
import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] array = new int[10];

        System.out.println("Введите 10 целых чисел: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = scan.nextInt();
        }
        System.out.println("Введенный массив: ");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        int sum = 0;
        System.out.println("Сумма всех элементов массива равна: ");
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        System.out.println(sum);

        int sumpositive = 0;
        System.out.println("Сумма положительных элементов массива равна: ");
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0)
                sumpositive += array[i];
        }
        System.out.println(sumpositive);

        boolean sorted = false;
        int swap;
        System.out.println("Введенный массив в порядке возрастания: ");
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < array.length-1; i++) {
                if (array[i] > array[i+1]) {
                    sorted = false;

                    swap = array[i];
                    array[i] = array[i+1];
                    array[i+1] = swap;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}

