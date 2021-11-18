package com.pb.kuranov.hw8;

import java.util.Scanner;

public class OnlineShop {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Для регистрации на сайте необходимо создать логин и пароль");
        System.out.println("Придумайте логин от 5 до 20 символов(можно использовать латиницу и цифры)");
        System.out.println("Введите логин:");
        String login1 = scan.nextLine();
        System.out.println("Придумайте пароль от 5 до 20 символов(можно использовать латиницу, цифры и знак подчеркивания)");
        System.out.println("Введите пароль:");
        String password1 = scan.nextLine();
        System.out.println("Повторите пароль:");
        String confirm1 = scan.nextLine();
        Auth auth = new Auth(login1, password1);

        try {
        auth.signUp(login1, password1, confirm1);
        } catch (WrongLoginException e1) {
        System.out.println("Повторите попытку регистрации!");
        return;
        } catch (WrongPasswordException e2) {
        System.out.println("Повторите попытку регистрации!");
        return;
        }

        System.out.println();
        System.out.println("Авторизация на сайте");
        System.out.println("Введите логин:");
        String login2 = scan.nextLine();
        System.out.println("Введите пароль:");
        String password2 = scan.nextLine();

        try {
        auth.signUp(login2, password2);
        } catch (WrongLoginException e1) {
        System.out.println("Повторите попытку авторизации!");
        }
    }
}
