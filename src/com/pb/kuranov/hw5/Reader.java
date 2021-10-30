package com.pb.kuranov.hw5;

import java.util.Arrays;

public class Reader {

    String fullName;
    String ticketNumber;
    String faculty;
    String dateOfBirth;
    String telephone;

    public Reader(String fullName, String ticketNumber, String faculty, String dateOfBirth, String telephone) {
        this.fullName = fullName;
        this.ticketNumber = ticketNumber;
        this.faculty = faculty;
        this.dateOfBirth = dateOfBirth;
        this.telephone = telephone;
    }
    public String getFullName() {
        return fullName;
    }
    public String getTicketNumber() {
        return ticketNumber;
    }
    public String getFaculty() {
        return faculty;
    }
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public String getTelephone() {
        return telephone;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }
    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    String getInfo() {
        return "ФИО читателя: " + fullName + ", номер читательского билета: " + ticketNumber +
                ", факультет: " + faculty + ", дата рождения: " + dateOfBirth + ", телефон: " + telephone + "";
    }
    public void takeBook(int count) {
        System.out.println(fullName + " взял " + count + " книги ");
    }
    public void takeBook(String... names) {
        System.out.println(fullName + " взял книги: " + Arrays.toString(names).replaceAll("\\[|\\]", ""));
    }
    public void takeBook(Book... books) {
        System.out.println(fullName + " взял книги: ");
        for (Book book : books) {
            System.out.println(book.getName() + " (" + book.getAuthor() + " " + book.getYear() + ")");
        }
    }
    public void returnBook(int count) {
        System.out.println(fullName + " вернул " + count + " книги ");
    }
    public void returnBook(String... names) {
        System.out.println(fullName + " вернул книги: " + Arrays.toString(names).replaceAll("\\[|\\]", ""));
    }
    public void returnBook(Book... books) {
        System.out.println(fullName + " вернул книги: ");
        for (Book book : books) {
            System.out.println(book.getName() + " (" + book.getAuthor() + " " + book.getYear() + ")");
        }
    }
}



