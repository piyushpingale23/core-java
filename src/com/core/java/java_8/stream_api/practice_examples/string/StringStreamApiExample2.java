package com.core.java.java_8.stream_api.practice_examples.string;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

// Count Occurrence Of Each Character
public class StringStreamApiExample2 {

    public static void main(String[] args) {

        String name = "programming";

        Map<Character, Long> duplicateCharactersOccurrence =
                name.chars()
                        .mapToObj(c -> (char) c)
                        .collect(Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()
                        ))
                        .entrySet()
                        .stream()
                        .filter(entry -> entry.getValue() > 1)
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue
                        ));

        System.out.println(duplicateCharactersOccurrence);

    }
}
