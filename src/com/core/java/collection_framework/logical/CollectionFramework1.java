package com.core.java.collection_framework.logical;

import java.util.*;
import java.util.stream.Collectors;

// Find Duplicate Elements in a List
public class CollectionFramework1 {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 2, 5, 1, 6, 3);

        Set<Integer> unique = new HashSet<>();

        Set<Integer> duplicate = list.stream()
                .filter(n -> !unique.add(n))
                .collect(Collectors.toSet());

        System.out.println("Duplicate Element: " + duplicate);

        List<Integer> nonDuplicateList = new ArrayList<>();
        List<Integer> duplicateList = new ArrayList<>();
        for (Integer i : list) {
            if (nonDuplicateList.contains(i)) {
                duplicateList.add(i);
            } else {
                nonDuplicateList.add(i);
            }
        }
        System.out.println("Duplicate Element: " + duplicateList);

        // Frequency Count
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        List<Integer> duplicateElements = new ArrayList<>();
        for (Integer i : list) {
            frequencyMap.put(i, frequencyMap.getOrDefault(i, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > 1) {
                duplicateElements.add(entry.getKey());
            }
        }
        System.out.println("Duplicate Element: " + duplicateElements);

    }
}
