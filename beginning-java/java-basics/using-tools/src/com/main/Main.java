package com.main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
	    /*  Some terms:
            noun - Person, place or thing
            verb - An action
            adjective - A description used to modify or describe a noun
            Enter your amazing code here!
        */
        // __Name__ is a __adjective__ __noun__. They are always __adverb__ __verb__.
        System.out.println("Enter a name:  ");
        String name = scanner.nextLine();
        System.out.println("Enter an adjective:  ");
        String adjective = scanner.nextLine();
        System.out.println("Enter a noun:  ");
        String noun = scanner.nextLine();
        System.out.println("Enter an adverb:  ");
        String adverb = scanner.nextLine();
        System.out.println("Enter a verb ending with -ing:  ");
        String verb = scanner.nextLine();

        System.out.println("Your tree story: \n ------------- \n");
        System.out.printf("%s is a %s %s. ", name, adjective, noun);
        System.out.printf("They are always %s %s. \n", adverb, verb);
    }
}
