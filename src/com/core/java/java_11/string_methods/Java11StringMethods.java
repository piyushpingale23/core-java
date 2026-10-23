package com.core.java.java_11.string_methods;


public class Java11StringMethods {

    public static void main(String[] args) {

        // 1. isBlank() - Checks empty or whitespace-only strings
        String value1 = "";
        String value2 = "   ";
        System.out.println("Empty string: " + value1.isBlank());
        System.out.println("Whitespace string: " + value2.isBlank());


        // 2. strip() - Removes leading and trailing whitespace
        String value3 = "   Java 11   ";
        System.out.println("strip(): [" + value3.strip() + "]");


        // 3. stripLeading() - Removes leading whitespace
        System.out.println("stripLeading(): [" + value3.stripLeading() + "]");


        // 4. stripTrailing() - Removes trailing whitespace
        System.out.println("stripTrailing(): [" + value3.stripTrailing() + "]");


        // 5. lines() - Splits text into a stream of lines
        String text = "Java\nPython\nJavaScript";

        System.out.println("Lines:");

        text.lines().forEach(System.out::println);


        // 6. repeat() - Repeats a string a specified number of times
        String language = "Java ";
        System.out.println("Repeated: " + language.repeat(3));
        System.out.println("Separator: " + "-".repeat(10));
    }
}

