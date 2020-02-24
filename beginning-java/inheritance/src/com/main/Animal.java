package com.main;

public class Animal {
    private String sound = "";

    public Animal(String sound) {
        this.sound = sound;
    }

    void makeSound() {
        System.out.println(sound);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": sound = " + sound;
    }
}
