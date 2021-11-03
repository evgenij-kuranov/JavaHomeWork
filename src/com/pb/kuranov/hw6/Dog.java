package com.pb.kuranov.hw6;

import java.util.Objects;

public class Dog extends Animal {

    private String colour;

    public Dog(String colour) {
        super("кость", "будка");
        this.colour = colour;
    }
    public String getColour() {
        return colour;
    }
    public void setColour(String colour) {
        this.colour = colour;
    }
    @Override
    public void makeNoise() {
        System.out.println("cобака лает");
    }
    @Override
    public void eat() {
        System.out.println("cобака ест " + getFood());
    }
    @Override
    public void sleep() {
        System.out.println(getLocation() + " - место где спит собака");
    }
    @Override
    public String toString() {
        return "цвет: " + colour + " еда: " + getFood() + " место обитания: " + getLocation();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return Objects.equals(colour, dog.colour);
    }
    @Override
    public int hashCode() {
        return Objects.hash(colour);
    }
}
