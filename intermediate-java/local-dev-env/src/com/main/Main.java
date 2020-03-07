package com.main;


import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        System.out.println("This is class path: " + System.getProperty("java.class.path"));
        Set<String> propNames = new TreeSet<>(System.getProperties().stringPropertyNames());
        System.out.println("========= Properties are: =========");
        for (String property : propNames){
            System.out.printf("%s is %s %n", property, System.getProperty(property));
        }
    }
}
