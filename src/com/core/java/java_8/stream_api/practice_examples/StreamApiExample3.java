package com.core.java.java_8.stream_api.practice_examples;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// Count Numbers Greater Than 50
public class StreamApiExample3 {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(10, 60, 70, 20, 90);

        numbers.stream()
                .sorted()
                .forEach(System.out::println);
        System.out.println("----------");

        numbers.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
        System.out.println("----------");

        long countGreaterThan50 = numbers.stream()
                .filter(i -> i > 50)
                .count();

        System.out.println(countGreaterThan50);

    }
}
