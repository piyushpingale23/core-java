package com.core.java.java_8.stream_api.practice_examples;

import java.util.Arrays;
import java.util.List;

// Convert Names to Uppercase
public class StreamApiExample2 {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("john", "alice", "bob");

        System.out.println(names.stream()
                .map(String::toUpperCase)
                .toList());

    }
}
