package com.pb.kuranov.hw6;

public class Veterinarian {

    public Veterinarian() {
    }

    public static void treatAnimal(Animal animal) {
        System.out.println("еда: " + animal.getFood() + " место обитания: " + animal.getLocation());
    }
}
