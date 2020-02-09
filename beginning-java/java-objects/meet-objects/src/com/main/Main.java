package com.main;

import com.main.java.PezDispenser;

public class Main {

    public static void main(String[] args) {

        System.out.println("We are making a new PEZ dispenser");
        PezDispenser dispenser = new PezDispenser("Luke");

//        cant change because characterName is private
//        dispenser.characterName = "Darth Vader";

        System.out.printf("The dispenser is %s %n", dispenser.getCharacterName());

//        doesn't work with final keyword:
//        String before = dispenser.swapHead("Darth Vader");
//        System.out.printf("It was %s but Chris switched it to %s %n", before, dispenser.getCharacterName());
    }
}
