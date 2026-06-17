package com.core.java.java_8.stream_api.practice_examples;

import java.util.Arrays;
import java.util.List;

// Find All Even Numbers
public class StreamApiExample1 {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .toList();

        System.out.println(evenNumbers);

    }
}
