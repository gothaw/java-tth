package com.main;

public class Dog extends Animal {

    public Dog(){
        super("bark");
    }

    @Override
    void makeSound() {
        super.makeSound();
        System.out.println("*wags tail*");
    }
}
