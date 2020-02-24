package com.main;

public class Dog extends Animal {

    public Dog(String sound){
        super(sound);
    }

    @Override
    public void findFood() {
        System.out.println("*looks at human*");
        makeSound();
    }

    @Override
    public void makeSound() {
        super.makeSound();
        System.out.println("*wags tail*");
    }
}
