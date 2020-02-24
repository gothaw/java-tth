package com.main;

public class Main {

    public static void main(String[] args) {
        Object[] list = {new Dog(), new DogFood()};
        // Casting
        Dog dog = (Dog) list[0];
        dog.makeSound();
        ((Dog)list[0]).makeSound();
        // Using for loop and checking instanceof
        for (Object object : list){
            if(object instanceof Animal){
                ((Animal) object).makeSound();
            }
        }
    }
}
