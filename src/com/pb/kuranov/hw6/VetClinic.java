package com.pb.kuranov.hw6;


import java.lang.reflect.Constructor;

import static com.pb.kuranov.hw6.Veterinarian.treatAnimal;

public class VetClinic {
    public static void main(String[] args) throws Exception {
        Dog dog = new Dog("коричневая");
        Cat cat = new Cat("сиамская");
        Horse horse = new Horse(150);

        Animal[] animals = new Animal[]{dog, cat, horse};
        for (Animal a : animals) {
            treatAnimal(a);
        }

        Class clazz = Class.forName("com.pb.kuranov.hw6.Veterinarian");
        Constructor constr = clazz.getConstructor(new Class[]{});
        Object obj = constr.newInstance();
    }
}
