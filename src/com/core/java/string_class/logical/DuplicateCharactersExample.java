package com.core.java.string_class.logical;

import java.util.*;

public class DuplicateCharactersExample {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter sentence -> ");
        String s = sc.nextLine();

        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        Set<Character> duplicates = new HashSet<>();

        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > 1) {
                duplicates.add(entry.getKey());
            }
        }

        System.out.println("Duplicate characters: " + duplicates);
    }
}
