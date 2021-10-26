package com.pb.kuranov.hw4;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите первую фразу: ");
        String sentence1 = scan.nextLine().toLowerCase();
        System.out.println("Введите вторую фразу: ");
        String sentence2 = scan.nextLine().toLowerCase();
        String result = anagram(sentence1, sentence2);
        System.out.println(result);
    }
    static String anagram(String a, String b) {
        String answer = "";
        String phrase1 = a.replaceAll("[ ,.!:;?-]+", "");
        String phrase2 = b.replaceAll("[ ,.!:;?-]+", "");
        char[] array1 = phrase1.toCharArray();
        char[] array2 = phrase2.toCharArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        if (Arrays.equals(array1, array2)) {
            answer = "Эти два выражения являются анаграммой";
        } else {
            answer = "Эти два выражения не являются анаграммой";
        }
        return answer;
   }
}
