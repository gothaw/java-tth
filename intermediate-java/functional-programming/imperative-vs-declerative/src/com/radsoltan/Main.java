package com.radsoltan;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    List<String> ingredients = Arrays.asList(
	            "flour",
                "salt",
                "baking powder",
                "butter",
                "eggs",
                "milk"
        );

	    // Imperative
	    // variable to store the state
	    boolean hasEggs = false;
        for (String ingredient : ingredients) {
            if (ingredient.equals("eggs")) {
                hasEggs = true;
                break;
            }
        }

	    if (hasEggs) {
            System.out.println("Sorry! It has eggs :(");
        }

	    // Declarative
        if (ingredients.contains("eggs")){
            System.out.println("Sorry! It has eggs :(");
        }

    }
}
