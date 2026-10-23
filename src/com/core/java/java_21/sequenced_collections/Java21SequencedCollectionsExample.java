package com.core.java.java_21.sequenced_collections;

import java.util.ArrayList;
import java.util.List;

public class Java21SequencedCollectionsExample {

    public static void main(String[] args) {

        // ArrayList supports modification at both ends
        List<String> languages = new ArrayList<>(List.of("Java", "Python", "JavaScript"));
        System.out.println("Original: " + languages);

        // Retrieve first and last elements
        System.out.println("First: " + languages.getFirst());
        System.out.println("Last: " + languages.getLast());

        // Add elements at both ends
        languages.addFirst("C++");
        languages.addLast("SQL");
        System.out.println("After adding: " + languages);

        // Reverse-ordered view
        System.out.println("Reversed: " + languages.reversed());

        // Remove elements from both ends
        System.out.println("Removed first: " + languages.removeFirst());
        System.out.println("Removed last: " + languages.removeLast());

        System.out.println("Final list: " + languages);
    }
}
