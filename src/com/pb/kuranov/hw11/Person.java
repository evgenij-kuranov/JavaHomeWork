package com.pb.kuranov.hw11;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

public class Person implements Comparable<Person> {

    private String fio;
    private LocalDate dateOfBirth;
    private ArrayList<String> phones;
    private String place;
    private LocalDateTime redaction;

    public Person() {
    }

    public Person(String fio, LocalDate dateOfBirth, ArrayList<String> phones, String place, LocalDateTime redaction) {
        this.fio = fio;
        this.dateOfBirth = dateOfBirth;
        this.phones = phones;
        this.place = place;
        this.redaction = redaction;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public ArrayList<String> getPhones() {
        return phones;
    }

    public void setPhones(ArrayList<String> phones) {
        this.phones = phones;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public LocalDateTime getRedaction() {
        return redaction;
    }

    public void setRedaction(LocalDateTime redaction) {
        this.redaction = redaction;
    }

    @Override
    public String toString() {
        return ("\nФИО: " + fio + ", Дата рождения: " + dateOfBirth +
                ", Телефон: " + phones + ", Адрес: " + place +
                ", Время внесения последнего измнения: " + redaction).replaceAll("\\[|\\]","");
    }
    public void addContact(Scanner scan, Person person) {
        ArrayList<String> phones = new ArrayList<>();
        System.out.println("Создание нового контакта");
        System.out.println("Введите ФИО: ");
        String fio = scan.nextLine();
        person.setFio(fio);
        System.out.println("Введите дату рождения в формате гггг-мм-дд: ");
        String date = scan.nextLine();
        LocalDate localDate = LocalDate.parse(date);
        person.setDateOfBirth(localDate);
        System.out.println("Введите телефон: ");
        String phone = scan.nextLine();
        phones.add(phone);
        String choise;
        do {
            System.out.println("Хотите добавить еще один телефон? ");
            System.out.println("Введите 1. ДА 2. НЕТ: ");
            choise = scan.nextLine();
            switch (choise) {
                case "1":
                    System.out.println("Введите телефон: ");
                    phone = scan.nextLine();
                    phones.add(phone);
                    System.out.println("Телефон успешно добавлен! ");
                    break;
                case "2":
                    person.setPhones(phones);
                    break;
            }
        } while (choise.equals("1"));
        System.out.println("Введите адрес: ");
        String place = scan.nextLine();
        person.setPlace(place);
        person.setRedaction(LocalDateTime.now());
    }
    public void redactContact (Scanner scan, Person person) {
                System.out.println("Введите параметр для изменения: ");
                System.out.println("1. ФИО, 2. Дата рождения, 3. Адрес, 4. Телефон: ");
                String param = scan.nextLine();
                switch (param) {
                    case"1":
                        System.out.println("Введите новое значение поля ФИО: ");
                        String newFio = scan.nextLine();
                        person.setFio(newFio);
                        person.setRedaction(LocalDateTime.now());
                        break;
                    case"2":
                        System.out.println("Введите новое значение поля Дата рождения: ");
                        String newDate = scan.nextLine();
                        LocalDate l = LocalDate.parse(newDate);
                        person.setDateOfBirth(l);
                        person.setRedaction(LocalDateTime.now());
                        break;
                    case"3":
                        System.out.println("Введите новое значение поля адрес: ");
                        String newAdress = scan.nextLine();
                        person.setPlace(newAdress);
                        person.setRedaction(LocalDateTime.now());
                        break;
                    case "4":
                        System.out.println("Выберите опцию для изменения телефона: ");
                        System.out.println("1. Добавить дополнительный телефон ");
                        System.out.println("2. Удалить один из телефонов ");
                        String phoneOption = scan.nextLine();
                        switch (phoneOption) {
                            case "1":
                            System.out.println("Введите дополнительный телефон: ");
                            String newPhone = scan.nextLine();
                            phones.add(newPhone);
                            person.setPhones(phones);
                            person.setRedaction(LocalDateTime.now());
                            break;
                            case "2":
                            System.out.println(phones);
                            System.out.println("Введите номер телефона для удаления: ");
                            String removePhone = scan.nextLine();
                            phones.removeIf(p -> removePhone.equals(p));
                            person.setRedaction(LocalDateTime.now());
                            break;
                        }
                    break;
                }
            }
    @Override
    public int compareTo(Person o) {
        return 0;
    }
}



