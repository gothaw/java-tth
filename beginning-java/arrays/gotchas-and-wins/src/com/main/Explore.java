package com.main;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Explore {

    public static void main(String[] args) {
        String[] friends = {"Ben", "Alena", "Mike"};

        // Adding new element
        // First way
        String[] friendsAndMe = new String[4];
        System.arraycopy(friends, 0, friendsAndMe, 0, friends.length);
        friendsAndMe[3] = "Rad";
        System.out.println(Arrays.toString(friendsAndMe));
        // Second way
        String[] friendsAndMe2 = Arrays.copyOf(friends, friends.length + 1);
        friendsAndMe2[3] = "Rad";
        System.out.println(Arrays.toString(friendsAndMe2));

        // Sorting and array
        String[] friends2 = {"Ben", "Alena", "Treasury", "Mike", "Craig"};
        Arrays.sort(friends2);
        System.out.println(Arrays.toString(friends2));
        // Sorting by different comparator
        String[] friends3 = {"Ben", "Alena", "Treasury", "Mike", "Craig"};
        Arrays.sort(friends2, Comparator.comparing(String::length));
        System.out.println(Arrays.toString(friends2));
        Arrays.sort(friends2, Comparator.comparing(String::length).reversed());
        System.out.println(Arrays.toString(friends2));

        //Arrays in method declarations
        String spot1 = pickLunchSpot("Que Sabrosa", "Las Primas", "Life of Pie");
        System.out.println(spot1);
        String spot2 = pickLunchSpot();
        System.out.println(spot2);
    }

    public static String pickLunchSpot(String... spots){
        System.out.printf("Randomly picking %d lunch spots. %n", spots.length);
        if (spots.length == 0) {
            return "Some place with tacos";
        }
        Random random = new Random();
        return spots[random.nextInt(spots.length)];
    }
}
