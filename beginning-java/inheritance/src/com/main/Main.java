package com.main;

public class Main {

    public static void main(String[] args) {
        Dog dog1 = new Dog("bark");
        // Overriding methods
        System.out.println(dog1.toString());
        dog1.findFood();
        Dog dog2 = new Dog("woof");
        Dog dog3 = new Dog("bark");
        // Object equality
        System.out.println(dog1.equals(dog2));
        System.out.println(dog1.equals(dog3));
    }
}
