package com.core.java.java_12;

public class Java12StringMethods {

    public static void main(String[] args) {

        // 1. indent(): add two spaces to every line
        String text = "Java\nSpring Boot";
        System.out.println(text.indent(2));

        // 2. transform(): apply a function to a String
        String name = "  java  ";
        String result = name.transform(
                value -> value.strip().toUpperCase()
        );
        System.out.println(result);

        // 3. transform(): convert String to Integer
        int number = "100".transform(Integer::parseInt);
        System.out.println(number + 50);
    }
}
