package com.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> groceryLine = new ArrayList<>();

        // adding elements
        groceryLine.add("Jerome");
        groceryLine.add("Beth");
        groceryLine.add("Sam");

        System.out.println(groceryLine);

        // removing elements
        groceryLine.remove("Beth");

        System.out.println(groceryLine);

        groceryLine.add("Beth");
        groceryLine.remove(2);

        // accessing elements
        String jerome = groceryLine.get(0);
        System.out.println(jerome);

        // indexOf()
        int samIndex = groceryLine.indexOf("Sam");
        System.out.println(samIndex);
        int pamIndex = groceryLine.indexOf("Pam");
        System.out.println(pamIndex);

        // size()
        System.out.println(groceryLine.size());

        for(String name : groceryLine){
            System.out.println(name);
        }

        // other methods

        // clears the list
        groceryLine.clear();
        System.out.println(groceryLine);

        // adding elements
        groceryLine.add("Sam");
        groceryLine.add("Beth");
        groceryLine.add("Jerome");

        // replacing item
        groceryLine.set(1,"Barbra");
        System.out.println(groceryLine);

        // changing to array
        System.out.println(Arrays.toString(groceryLine.toArray()));

    }
}
