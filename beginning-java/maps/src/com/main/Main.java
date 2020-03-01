package com.main;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static final String BREAKFAST = "breakfast";
    public static final String LUNCH = "lunch";
    public static final String DINNER = "dinner";

    public static void main(String[] args) {
        Map<String, String> meals = new HashMap<>();

        // adding values
        meals.put(BREAKFAST,"waffles");
        meals.put(LUNCH,"gyros");
        meals.put(DINNER,"enchiladas");

        System.out.println(meals);

        // getting values
        System.out.println(meals.get(DINNER));

        // removing values
        String lunch = meals.remove(LUNCH);
        System.out.println(lunch);

        // checking if contains a key or value
        meals.put(LUNCH,"chicken");

        boolean hasLunch = meals.containsKey(LUNCH);
        boolean hasBrunch = meals.containsValue("waffles");
        System.out.println(hasLunch);
        System.out.println(hasBrunch);

        // size
        int size = meals.size();
        System.out.println(size);

    }
}
