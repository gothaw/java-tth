package com.main;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // while
        askQuestions();
        // do while
        miniGolf();
        // for
        bottlesOfMilk();
        // arrays
        jacksonOldSchool();
        // foreach
        jacksonNewSchool();
        // dunk tank
        dunkTankWhile();
        dunkTankFor();
        // ice cream
        makeIceCream();
        // branching statements
        giveAwayTShirt();
    }

    /**
     * while loop
     */
    public static void askQuestions() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Are there any questions?");
        String anyQuestions = scanner.nextLine();

        while (anyQuestions.equals("yes")) {
            System.out.println("What is your question?");
            String question = scanner.nextLine();
            System.out.printf("I don't understand: %s %n", question);
            System.out.println("Any more questions?");
            anyQuestions = scanner.nextLine();
        }

        System.out.println("Next slide...");
    }

    /**
     * do while loop
     */
    public static void miniGolf() {

        Random luck = new Random();
        int numberOfPutts = 0;
        boolean ballInHole = false;
        do {
            System.out.printf("Putt putt %n");
            ballInHole = luck.nextBoolean();
            numberOfPutts++;
        } while (!ballInHole);

        System.out.printf("You got in %d putts %n", numberOfPutts);
    }

    /**
     * for loop
     */
    public static void bottlesOfMilk() {
        for (int i = 99; i > 0; i--) {
            System.out.printf("%d bottles of milk on the wall... %n", i);
        }
    }

    /**
     * arrays
     */
    public static void jacksonOldSchool() {
        String[] jacksonArray = {"Michael", "Jackie", "Tito", "Jermaine", "Marlon", "Randy"};
        System.out.println("The Jackson 5 are: ");

        for (int i = 0; i < jacksonArray.length; i++) {
            String jackson = jacksonArray[i];
            System.out.printf("%s Jackson %n", jackson);
        }
    }

    /**
     * for each loop
     */
    public static void jacksonNewSchool() {
        String[] jacksonArray = {"Michael", "Jackie", "Tito", "Jermaine", "Marlon", "Randy"};
        System.out.println("The Jackson 5 are: ");

        for (String jackson : jacksonArray) {
            System.out.printf("%s Jackson %n", jackson);
        }
    }

    /**
     * while
     */
    public static void dunkTankWhile() {
        Random skill = new Random();
        boolean isDunked = false;
        int ballsThrown = 0;
        while (!isDunked && ballsThrown < 3) {
            System.out.printf("Try #%d ... %n", ballsThrown + 1);
            isDunked = skill.nextBoolean();
            ballsThrown++;
        }
        if (isDunked) {
            System.out.println("Air punch!");
        } else {
            System.out.println("Boo! :D");
        }
    }

    /**
     * for
     */
    public static void dunkTankFor() {
        Random skill = new Random();
        boolean isDunked = false;
        for (int ballsThrown = 0; !isDunked && ballsThrown < 3; ballsThrown++) {
            System.out.printf("Try #%d ... %n", ballsThrown + 1);
            isDunked = skill.nextBoolean();
        }
        if (isDunked) {
            System.out.println("Air punch!");
        } else {
            System.out.println("Boo! :D");
        }
    }

    /**
     * nested loops
     */
    public static void makeIceCream() {
        String[] sweetFlavours = {"Carmel", "Cinnamon", "Watermelon", "Baked Beans"};
        String[] savoryFlavours = {"Sea Salt", "Potato Chip", "Carrot", "Barbeque Sauce"};
        for (String sweet :
                sweetFlavours) {
            for (String savoury :
                    savoryFlavours) {
                System.out.printf("%s and %s %n", sweet, savoury);
            }
        }
    }

    /**
     * branching statements
     */
    public static void giveAwayTShirt() {
        String[] rsvps = Rsvps.shuffled();
        Scanner scanner = new Scanner(System.in);
        int prizesGivenAway = 0;
        int drawingNumber = 0;

        while (prizesGivenAway < 5){
            String winner = rsvps[drawingNumber];
            drawingNumber++;
            System.out.printf("Is %s present? %n", winner);
            String isHere = scanner.nextLine();
            if(isHere.equalsIgnoreCase("no")){
                continue;
            }
            System.out.println("What is your shirt size?");
            String size = scanner.nextLine();
            prizesGivenAway++;
        }
    }
}
