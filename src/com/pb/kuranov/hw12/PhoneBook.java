package com.pb.kuranov.hw12;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.*;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.Comparator;
import java.util.Scanner;

public class PhoneBook {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        SimpleModule module = new SimpleModule();
        module.addSerializer(LocalDate.class, new LocalDateSerializer());
        module.addDeserializer(LocalDate.class, new LocalDateDeserializer());
        mapper.registerModule(module);
        SimpleModule module1 = new SimpleModule();
        module1.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
        module1.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());
        mapper.registerModule(module1);

        ArrayList<Person> book = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("Добро пожаловать в телефонную книгу!");
            System.out.println("Для начала работы выберите опцию:");
            System.out.println("1. Записать новый контакт");
            System.out.println("2. Удалить контакт");
            System.out.println("3. Редактировать контакт");
            System.out.println("4. Сортировать контакты");
            System.out.println("5. Поиск контакта");
            System.out.println("6. Записать контакты в файл");
            System.out.println("7. Загрузить контакты из файла");
            System.out.println("8. Закончить работу");
            String option = scan.nextLine();

            switch (option) {
                case "1":
                    Person person = new Person();
                    person.addContact(scan, person);
                    book.add(person);
                    System.out.println("Контакт успешно добавлен!");
                    break;
                case "2":
                    System.out.println("Введите ФИО контакта для удаления");
                    String name = scan.nextLine();
                    book.removeIf(p -> name.equals(p.getFio()));
                    System.out.println("Контакт успешно удален!");
                    break;
                case "3":
                    System.out.println("Введите ФИО контакта для изменения");
                    String name1 = scan.nextLine();
                    book.forEach(p -> {
                        if (p.getFio().equals(name1)) {
                            p.redactContact(scan, p);
                        }
                    });
                    System.out.println("Контакт успешно изменен!");
                    break;
                case "4":
                    System.out.println("Введите параметр для сортировки: ");
                    System.out.println("1. ФИО, 2. Дата рождения: ");
                    String param = scan.nextLine();
                    switch (param) {
                        case "1":
                            book.stream()
                                    .sorted(Comparator.comparing(Person::getFio))
                                    .forEach(System.out::println);
                            break;
                        case "2":
                            book.stream()
                                    .sorted(Comparator.comparing(Person::getDateOfBirth))
                                    .forEach(System.out::println);
                            break;
                    }
                    break;
                case "5":
                    System.out.println("Введите ФИО контакта для поиска");
                    String name2 = scan.nextLine();
                    book.forEach(p -> {
                        if (p.getFio().equals(name2)) {
                            System.out.println(p);
                        }
                    });
                    break;
                case "6":
                    try {
                    String json = mapper.writeValueAsString(book);
                    File file = Paths.get("src/com/pb/kuranov/hw12/person.json").toFile();
                    FileOutputStream outputStream = new FileOutputStream(file);
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                    objectOutputStream.writeObject(json);
                    objectOutputStream.close();
                    System.out.println("Даные успешно записаны в файл!");
                    } catch (FileNotFoundException e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    } catch (JsonProcessingException e2) {
                        System.out.println("Ошибка: " + e2.getMessage());
                    } catch (IOException e3) {
                        System.out.println("Ошибка: " + e3.getMessage());
                    }
                break;
                case "7":
                    try {
                        File file1 = Paths.get("src/com/pb/kuranov/hw12/person.json").toFile();
                        FileInputStream fileInputStream = new FileInputStream(file1);
                        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                        String persons = (String) objectInputStream.readObject();
                        ArrayList<Person> persons1 = mapper.readValue(persons, new TypeReference<ArrayList<Person>>() {});
                        book.addAll(persons1);
                        System.out.println("Даные успешно загружены из файла!");
                    } catch (IOException e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    } catch (ClassNotFoundException e2) {
                        System.out.println("Ошибка: " + e2.getMessage());
                    }
                break;
                case "8":
                    System.out.println("Хорошего дня!");
                    return;
                default:
                    System.out.println("Вы ввели неверный аргумент!");
            }
        }
    }
}
