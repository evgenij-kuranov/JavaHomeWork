package com.pb.kuranov.hw6;

import java.util.Objects;

public class Horse extends Animal {

    private int weight;

    public Horse(int weight) {
        super("овес", "конюшня");
        this.weight = weight;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    @Override
    public void makeNoise() {
        System.out.println("лошадь ржет");
    }
    @Override
    public void eat() {
        System.out.println("лошадь ест " + getFood());
    }
    @Override
    public void sleep() {
        System.out.println(getLocation() + " - место где спит лошадь");
    }
    @Override
    public String toString() {
        return "вес: " + weight + " еда: " + getFood() + " место обитания: " + getLocation();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Horse horse = (Horse) o;
        return weight == horse.weight;
    }
    @Override
    public int hashCode() {
        return Objects.hash(weight);
    }
}
