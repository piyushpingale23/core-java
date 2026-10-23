package com.core.java.collection_framework.logical;

import java.util.*;
import java.util.stream.Collectors;

/*
 * Problem Statement:
 * Given a list of integers:
 * [1, 2, 3, 4, 2, 5, 1, 6, 3]
 *
 * 1. Calculate frequency of each number.
 * 2. Find duplicate numbers along with their count.
 * 3. Find only duplicate numbers.
 * 4. Find numbers appearing only once.
 * 5. Find the first duplicate number.
 * 6. Find the most frequent number.
 */

public class CollectionFramework2 {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 2, 5, 1, 6, 3);

        // 1. Frequency Count
        Map<Integer, Integer> frequencyCountMap = new HashMap<>();

        for (Integer num : list) {
            frequencyCountMap.put(num, frequencyCountMap.getOrDefault(num, 0) + 1);
        }

        System.out.println("Frequency Count:");
        System.out.println(frequencyCountMap);

        Map<Integer, Integer> frequencyMap = new TreeMap<>();
        for (Integer i : list) {
            frequencyMap.put(i, frequencyMap.getOrDefault(i, 0) + 1);
        }
        System.out.println("Frequency Map: " + frequencyMap);

        // 2. Duplicate Numbers With Count
        Map<Integer, Integer> duplicateEntries = frequencyCountMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue
                ));

        System.out.println("\nDuplicate Numbers With Count:");
        System.out.println(duplicateEntries);

        Map<Integer, Integer> duplicateNoAlongWithCount = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > 1) {
                duplicateNoAlongWithCount.put(entry.getKey(), entry.getValue());
            }
        }
        System.out.println("Duplicate Number along with their count: " + duplicateNoAlongWithCount);

        // 3. Only Duplicate Numbers
        List<Integer> duplicateNumbers = frequencyCountMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println("\nDuplicate Numbers:");
        System.out.println(duplicateNumbers);

        List<Integer> duplicateNumbers1 = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > 1) {
                duplicateNumbers1.add(entry.getKey());
            }
        }
        System.out.println("Duplicate numbers : " + duplicateNumbers1);

        // 4. Numbers Appearing Only Once
        List<Integer> uniqueNumbers = frequencyCountMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println("\nUnique Numbers:");
        System.out.println(uniqueNumbers);

        // 5. First Duplicate Number
        Set<Integer> set = new HashSet<>();
        Integer firstDuplicate = null;

        for (Integer num : list) {
            if (!set.add(num)) {
                firstDuplicate = num;
                break;
            }
        }

        System.out.println("\nFirst Duplicate Number:");
        System.out.println(firstDuplicate);

        // 6. Most Frequent Number
        Map.Entry<Integer, Integer> maxEntry =
                Collections.max(
                        frequencyCountMap.entrySet(),
                        Map.Entry.comparingByValue()
                );

        System.out.println("\nMost Frequent Number:");
        System.out.println(maxEntry.getKey() + " -> " + maxEntry.getValue());

        int mostFrequentNumber = 0;
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > mostFrequentNumber) {
                mostFrequentNumber = entry.getKey();
            }
        }
        System.out.println("Most Frequent Number : " + mostFrequentNumber);
    }
}