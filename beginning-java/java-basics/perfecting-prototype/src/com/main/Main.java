package com.main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is your age?");

        // AGE VALIDATION

        String ageAsString = scanner.nextLine();
        int age = Integer.parseInt(ageAsString);
        // Other way:
        // int age = scanner.nextInt();
        // scanner.nextLine();
        if (age < 13) {
            // Insert exit code
            System.out.println("Sorry you must be at least 13 to use this program.");
            // Program terminates 0 - program finished intentionally any other parameter means that program finish abnormally
            System.exit(0);
        }

        // __Name__ is a __adjective__ __noun__. They are always __adverb__ __verb__.

        System.out.println("Enter a name:  ");
        String name = scanner.nextLine();
        System.out.println("Enter an adjective:  ");
        String adjective = scanner.nextLine();

        // NOUN VALIDATION
        System.out.println("Enter a noun:  ");
        String noun;
        String[] forbiddenWordsArray = {"dork", "douche", "idiot", "moron", "dumb"};
        boolean isInvalidWord;

        do {
            isInvalidWord = true;
            noun = scanner.nextLine();
            for (String word : forbiddenWordsArray) {
                if (noun.toLowerCase().contains(word)) {
                    System.out.println("This language is not allowed! Please reenter the name!");
                    isInvalidWord = false;
                    break;
                }
            }
        } while (!isInvalidWord);

        System.out.println("Enter an adverb:  ");
        String adverb = scanner.nextLine();
        System.out.println("Enter a verb ending with -ing:  ");
        String verb = scanner.nextLine();

        System.out.println("Your tree story: \n ------------- \n");
        System.out.printf("%s is a %s %s. ", name, adjective, noun);
        System.out.printf("They are always %s %s. \n", adverb, verb);
    }
}
