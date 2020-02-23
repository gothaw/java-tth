package com.main;

public class Arrays {

    public static void main(String[] args) {
        String[] cowNames = {"Merry", "Mia", "Danny", "Maria"};

        Cow[] cows = new Cow[cowNames.length];

        for (int i = 0; i < cows.length; i++) {
            cows[i] = new Cow(cowNames[i]);
        }

        for (Cow cow : cows) {
            System.out.printf("Cow name is %s%n", cow.getName());
        }

    }
}
