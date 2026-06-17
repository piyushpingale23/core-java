package com.core.java.java_8.stream_api.practice_examples.string;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

// Find Duplicate Characters
public class StringStreamApiExample1 {

    public static void main(String[] args) {

        String name = "programming";

        List<Character> duplicateCharacters = name.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();

        System.out.println(duplicateCharacters);

    }
}
