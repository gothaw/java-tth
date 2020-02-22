package com.main;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // Array Object
        String[] friends = new String[3];
        System.out.println(Arrays.toString(friends));
        friends[0] = "Mike";
        System.out.println(friends[0]);
        friends[1] = "Alan";
        System.out.println(Arrays.toString(friends));
        System.out.println(friends.length);
        friends[2] = "Ben";
        System.out.println(friends[friends.length - 1]);
        // Array literal
        String[] friendsLiteral = {"Mike", "Alan", "Ben"};
        System.out.println(Arrays.toString(friendsLiteral));
        String[] snacks;
        snacks = new String[] {"nachos", "m&ms", "snickers", "popcorn"};
    }
}
