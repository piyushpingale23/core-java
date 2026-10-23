package com.core.java.java_16.pattern_matching;

public class PatternMatchingExample {

    public static void main(String[] args) {

        Object value = "Java 16";

        // Before Java 16: traditional instanceof
        if (value instanceof String) {
            String text = (String) value;
            System.out.println("Traditional: " + text.toUpperCase());
        }

        // Java 16: pattern matching for instanceof
        if (value instanceof String text) {
            System.out.println("Pattern Matching: " + text.toUpperCase());
        }

        // When the object is not a String, the block is skipped
        Object number = 100;

        if (number instanceof String text) {
            System.out.println(text.toUpperCase());
        } else {
            System.out.println("The object is not a String");
        }
    }
}
