package com.pb.kuranov.hw2;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num1;
        int num2;
        String sign;

        System.out.print("Введите первое целое число: ");
        num1 = scan.nextInt();

        System.out.print("Введите действие(+-*/): ");
        sign = scan.next();

        System.out.print("Введите второе целое число: ");
        num2 = scan.nextInt();
        switch (sign) {
            case "+":
                System.out.print("Результат: " + (num1 + num2));
                break;
            case "-":
                System.out.print("Результат: " + (num1 - num2));
                break;
            case "*":
                System.out.print("Результат: " + (num1 * num2));
                break;
            case "/":
                if (num2 == 0) {
                    System.out.print("Действие невозможно!");
                } else {
                    System.out.print("Результат: " + (num1 / num2));
                }
                break;
                default:
                    System.out.println("Действие не распознано. Повторите попытку.");
        }
        }
    }
