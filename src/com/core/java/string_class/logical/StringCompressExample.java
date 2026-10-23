package com.core.java.string_class.logical;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class StringCompressExample {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter sentence -> ");
        String s = sc.nextLine();

        Map<Character, Integer> countFrequency = new LinkedHashMap<>();
        char[] chars = s.toCharArray();

        for (Character c : chars) {
            countFrequency.put(c, countFrequency.getOrDefault(c, 0) + 1);
        }

        String compress = "";
        for (Map.Entry<Character, Integer> entry : countFrequency.entrySet()) {
            compress = compress + entry.getKey() + entry.getValue();
        }

        System.out.println(compress);

    }

}
