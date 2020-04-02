package com.radsoltan;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class Main {

    public static void yell(String words) {
        Objects.requireNonNull(words, () -> "Created issue" + Main.createIssue());
        System.out.printf("%s!!! %n", words.toUpperCase());
    }

    private static String createIssue() {
        System.out.println("Some external API call to a bug tracker.");
        return "#ABC123";
    }

    public static void main(String[] args) {
        List<String> ingredients = Arrays.asList(
                "flour",
                "salt",
                "baking powder",
                "butter",
                "eggs",
                "milk"
        );

        System.out.println("Imperative");
        for (String ingredient : ingredients) {
            System.out.println(ingredient);
        }

        System.out.println("Declarative");
        ingredients.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        System.out.println("Declarative - Lambdas - Long version");
        ingredients.forEach((String ingredient) -> {
            System.out.println(ingredient);
        });

        System.out.println("Declarative - Lambdas - Short version");
        ingredients.forEach(ingredient -> System.out.println(ingredient));

        System.out.println("Declarative - Lambdas - Consumer function explained");
        Consumer<String> printer = ingredient -> System.out.println(ingredient);
        ingredients.forEach(printer);

        System.out.println("Declarative - Method Reference");
        ingredients.forEach(System.out::println);
        Main.yell("But I want it!");
        ingredients.forEach(Main::yell);
    }
}
