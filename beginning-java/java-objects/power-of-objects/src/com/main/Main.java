package com.main;

public class Main {

    public static void main(String[] args) {

        System.out.println("We are making a new PEZ dispenser");
        System.out.printf("There are %d PEZ allowed in every dispenser. %n", PezDispenser.MAX_PEZ);

        PezDispenser dispenser = new PezDispenser("Luke");
        if (dispenser.isEmpty()) {
            System.out.println("Dispenser is empty.");
        }
        System.out.printf("The dispenser is %s %n", dispenser.getCharacterName());
        System.out.println("Filling the dispenser.");
        dispenser.fill();
        if (!dispenser.isEmpty()) {
            System.out.println("Dispenser is full.");
        }
        while (dispenser.dispense()){
            System.out.println("Chomp!");
        }
        if (dispenser.isEmpty()){
            System.out.println("Ate all the PEZ");
        }
        dispenser.fill(4);
        dispenser.fill(2);
        while (dispenser.dispense()){
            System.out.println("Chomp!!");
        }
        try{
            dispenser.fill(20);
            System.out.println("This will never happen.");
        } catch (IllegalArgumentException e){
            System.out.println("Hey there!");
            System.out.printf("This error was %s %n", e.getMessage());
        }
    }
}
