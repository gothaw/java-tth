package com.teamtreehouse.docgen;

import com.teamtreehouse.math.MathUtils;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {
    public static void main(String[] args) {
        // Getting a class object
        Class<?> clazz = MathUtils.class;

        // Get all declared methods
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            // Display method name
            System.out.printf("name: %s%n", method.getName());
            // Display parameter count
            System.out.printf("\t# params: %s%n", method.getParameterCount());
            // Display return type
            System.out.printf("\treturn type: %s%n", method.getReturnType().getSimpleName());
            // Display modifiers
            int mods = method.getModifiers();
            String modStr = Modifier.toString(mods);
            System.out.printf("\tmodifiers: %s%n", modStr);
        }
    }
}