package com.pb.kuranov.hw3;

import java.util.Random;
import java.util.Scanner;

public class Bingo {
    public static void main(String[] args) {
        System.out.println("Отгадайте число от 0 до 100, загаданное программой");
        System.out.println("Для досрочного окончания игры введите любое число больше 100");
        Scanner scan = new Scanner(System.in);
        Random random = new Random();

        int x = random.nextInt(101);
        int number;
        int attempt = 0;

        do {
            attempt++;
            System.out.println("Введите число:");
            number = scan.nextInt();

        if (number >= 101) {
            break;
        }
        if (number > x) {
            System.out.print("Загаданное число меньше вашего");
            System.out.println();
            continue;
        }
        if (number < x) {
            System.out.print("Загаданное число больше вашего");
            System.out.println();
            continue;
        }
        System.out.println("Поздравляем, Вы угадали число с " + attempt + " попытки!");
        break;
        } while (number != x);

        System.out.println("Конец игры!");
        }
    }
