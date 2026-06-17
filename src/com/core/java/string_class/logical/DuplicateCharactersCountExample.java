package com.core.java.string_class.logical;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DuplicateCharactersCountExample {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter sentence -> " );
        String s = sc.nextLine();

        Map<Character, Integer> characterCount = new HashMap<>();

        for (char c : s.toCharArray()) {
            characterCount.put(c, characterCount.getOrDefault(c, 0) + 1);
        }

        System.out.println(characterCount);


    }
}
