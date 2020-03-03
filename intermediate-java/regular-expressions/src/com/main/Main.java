package com.main;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your zipcode: ");
        String zipCode = scanner.nextLine();
        if (zipCode.matches("^\\d{5}(-\\d{4})?$")) {
            System.out.printf("%s is a valid zip code.%n", zipCode);
        } else {
            System.out.printf("%s is NOT a valid zip code.%n", zipCode);
        }
        String skills = "JavaScript, HTML, CSS and Java";
        for (String skill : skills.split("\\W+(and\\W+)?")) {
            System.out.printf("The skill is %s%n", skill);
        }
        String script = "Surely capturing shushes shall show how beneficial Regular Expressions actually are!";
        Pattern pattern = Pattern.compile("(\\w*(sh|ti|su|ci|tu|si)\\w*)", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(script);
        while (matcher.find()) {
            System.out.printf("%s is a shushy word because of %s%n", matcher.group(1), matcher.group(2));
        }
    }
}
