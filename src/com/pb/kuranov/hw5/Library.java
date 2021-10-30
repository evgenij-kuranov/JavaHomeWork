package com.pb.kuranov.hw5;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Властелин колец","Джон Р.Р. Толкин", "1955 г." );
        Book book2 = new Book("Гарри Поттер","Джоан Роулинг", "1997 г." );
        Book book3 = new Book("Зеленая Миля","Стивен Кинг", "1996 г." );

        Reader reader1 = new Reader("Иванов И.И.","1111", "филология", "01.01.1991", "093-111-11-11");
        Reader reader2 = new Reader("Петров П.П.","2222", "кибернетика", "02.02.1992", "066-222-22-22");
        Reader reader3 = new Reader("Сидоров С.С.","3333", "социология", "03.03.1993", "050-333-33-33");

        System.out.println("Список книг доступных в библиотеке: ");
        System.out.println(book1.bookInfo() + "\n" + book2.bookInfo() + "\n" + book3.bookInfo());
        System.out.println("Список читателей библиотеки: ");
        System.out.println(reader1.getInfo() + "\n" + reader2.getInfo() + "\n" + reader3.getInfo());

        reader1.takeBook(3);
        reader2.takeBook(book1.name, book2.name, book3.name);
        reader3.takeBook(book1, book2, book3);

        reader1.returnBook(3);
        reader2.returnBook(book1.name, book2.name, book3.name);
        reader3.returnBook(book1, book2, book3);
    }
}
