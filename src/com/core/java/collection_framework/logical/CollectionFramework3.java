package com.core.java.collection_framework.logical;

import java.util.LinkedHashMap;
import java.util.Map;

// 1. Find First Non-Repeated Character. output -> 'w'
// 2. Find First Repeated Character. output -> 's'
public class CollectionFramework3 {

    public static void main(String[] args) {

        String str = "swiss";

        Map<Character, Integer> frequencyMap = new LinkedHashMap<>();

        for (char ch : str.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        Character firstNonRepeated = null;

        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == 1) {
                firstNonRepeated = entry.getKey();
                break;
            }
        }

        Character firstRepeated = frequencyMap.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList().getFirst();

        System.out.println("First Non-Repeated Character: " + firstNonRepeated);
        System.out.println("First Repeated Character: " + firstRepeated);
    }
}
