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

    }
}
