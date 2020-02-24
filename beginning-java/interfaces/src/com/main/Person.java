package com.main;

public class Person implements Chattable{
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String chat(){
        return "Hi, I'm a Person!";
    }
}
