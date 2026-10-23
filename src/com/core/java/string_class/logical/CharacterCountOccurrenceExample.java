package com.core.java.string_class.logical;

import java.util.*;

public class CharacterCountOccurrenceExample {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter sentence -> ");
        String s = sc.nextLine();
        System.out.print("Enter character -> ");
        String ch = sc.nextLine();

        Map<Character, Integer> countFrequency = new LinkedHashMap<>();
        char[] chars = s.toCharArray();

        for (Character c : chars) {
            countFrequency.put(c, countFrequency.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : countFrequency.entrySet()) {
            if (entry.getKey().toString().equals(ch)) {
                System.out. println("Character " + ch + " occurred " + entry.getValue() + " times in " + s);
            }
        }
    }
}
