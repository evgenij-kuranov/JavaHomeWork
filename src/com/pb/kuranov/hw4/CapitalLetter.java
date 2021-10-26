package com.pb.kuranov.hw4;

import java.util.Scanner;

public class CapitalLetter {
    public static void main(String[] args) {
        System.out.println("Введите изначальное выражение: ");
        Scanner scan = new Scanner(System.in);
        String sentence = scan.nextLine();
        System.out.println(capitals(sentence));
    }
    static String capitals(String a) {
        String[] words = a.split(" ");
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String temp = words[i];
            output.append(Character.toUpperCase(temp.charAt(0))).append(temp.substring(1)).append(" ");
        }
        return output.toString();
    }
}



