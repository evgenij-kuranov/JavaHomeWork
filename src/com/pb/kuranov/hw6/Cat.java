package com.pb.kuranov.hw6;

import java.util.Objects;

public class Cat extends Animal {

    private String breed;

    public Cat(String breed) {
        super("корм", "диван");
        this.breed = breed;
    }
    public String getBreed() {
        return breed;
    }
    public void setBreed(String breed) {
        this.breed = breed;
    }
    @Override
    public void makeNoise() {
        System.out.println("кошка мяукает");
    }
    @Override
    public void eat() {
        System.out.println("кошка ест " + getFood());
    }
    @Override
    public void sleep() {
        System.out.println(getLocation() + " - место где спит кошка");
    }
    @Override
    public String toString() {
        return "порода: " + breed + " еда: " + getFood() + " место обитания: " + getLocation();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return Objects.equals(breed, cat.breed);
    }
    @Override
    public int hashCode() {
        return Objects.hash(breed);
    }
}
