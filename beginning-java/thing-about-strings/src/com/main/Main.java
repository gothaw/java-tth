package com.main;

public class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static void explore(String assumption,
                               boolean result) {
        StringBuilder sb = new StringBuilder();
        if (result) {
            sb.append(String.format("%sYAY!%s",
                    ANSI_GREEN,
                    ANSI_RESET));
        } else {
            sb.append(String.format("%sWAT???!%s",
                    ANSI_RED,
                    ANSI_RESET));
        }
        sb.append("  ");
        sb.append(assumption);
        if (!result) {
            sb.append(" (Your assumption is incorrect)");
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        int firstNumber = 12;
        int secondNumber = 12;
        explore("Primitives use double equals", firstNumber == secondNumber);
        Object firstObject = new Object();
        Object secondObject = new Object();
        // When you create an object. A variable represents an object reference in memory.
        // By using == we compare if the object references are referring to the same object.
        explore("Object references use double equals to check if they refer to the same object in memory, seemingly equal objects are not equal", firstObject != secondObject);
        Object sameObject = firstObject;
        explore("Object references must refer to the same object to use double equals", firstObject == sameObject);
        String firstString = "Craig";
        String secondString = "Craig";
        // When you create a string using "" we create a string literal. Since strings are immutable => their data and state can't change.
        // Compiler optimizes the code by storing references of string literals in a special place in memory.
        // Since the string won't change it creates a single instance of that string and makes all variables refer to that instance.
        // It stores these references in special place in memory called the string pool.
        explore("String literals are actually referring to the same object", firstString == secondString);
        // To create a unique string you need to use a constructor
        String differentString = new String("Craig");
        explore("String objects that contain the same character but point to different objects cannot use double equals", firstString != differentString);
        String anotherString = new String("Craig");
        explore("String Interning adds to the same String Pool where literals live, so you get back the same reference", anotherString.intern() == firstString);
        // !!! Using == on objects compares object references. It is used to check if references refer to same object in memory !!!
        // For object equality use equals method
        explore("All Objects should use equals to check equality", firstString.equals(differentString));
    }
}
