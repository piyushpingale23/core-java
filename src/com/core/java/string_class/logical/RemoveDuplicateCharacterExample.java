package com.core.java.string_class.logical;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class RemoveDuplicateCharacterExample {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter sentence -> ");
        String s = sc.nextLine();

        Map<Character, Integer> countFrequency = new LinkedHashMap<>();
        char[] chars = s.toCharArray();

        for (Character c : chars) {
            countFrequency.put(c, countFrequency.getOrDefault(c, 0) + 1);
        }

        String nonDuplicateCharacter = "";
        for (Map.Entry<Character, Integer> entry : countFrequency.entrySet()) {
            if (entry.getValue() == 1) {
                nonDuplicateCharacter = nonDuplicateCharacter + entry.getKey();
            }
        }

        System.out.println("Non duplicate character string: " + nonDuplicateCharacter);
    }

}
