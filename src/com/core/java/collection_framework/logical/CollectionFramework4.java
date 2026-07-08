package com.core.java.collection_framework.logical;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

// Count Occurrence of Each Word
public class CollectionFramework4 {

    public static void main(String[] args) {

        List<String> list = List.of("Java","Spring","Java","Hibernate","Spring","Java");
        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String s : list) {
            frequencyMap.put(s, frequencyMap.getOrDefault(s, 0) + 1);
        }

        System.out.println(frequencyMap);

    }
}
