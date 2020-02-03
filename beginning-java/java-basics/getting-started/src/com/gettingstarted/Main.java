package com.gettingstarted;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        /*
            Workspace uses:  Console console = System.console();
            Which does not work in IDE
         */
        System.out.println("Hello world");
        System.out.println("This is new line.\nThis is new line.\n");

        // scanner
        System.out.println("What is your name???");
        String firstName = scanner.nextLine();

        System.out.println("Hello " + firstName);
        // Format or printf can be used with parameters
        System.out.printf("%s is learning Java", firstName);


    }
}
