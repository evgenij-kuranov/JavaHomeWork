package com.pb.kuranov.hw5;

public class Book {
    String name;
    String author;
    String year;

    public Book(String name, String author, String year) {
        this.name = name;
        this.author = author;
        this.year = year;
    }
    public String getName() {
        return name;
    }
    public String getAuthor() {
        return author;
    }
    public String getYear() {
        return year;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setYear(String year) {
        this.year = year;
    }
    String bookInfo() {
        return "Название книги: " + name + ", автор книги: " + author + ", год издания: " + year + "";
    }
}

