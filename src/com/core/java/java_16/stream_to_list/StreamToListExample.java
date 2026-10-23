package com.core.java.java_16.stream_to_list;

import java.util.List;
import java.util.stream.Collectors;

public class StreamToListExample {

    public static void main(String[] args) {

        List<String> names = List.of("Java", "Spring", "SQL", "Python");

        // Before Java 16
        List<String> traditionalResult = names.stream()
                .filter(name -> name.length() > 3)
                .collect(Collectors.toList());
        System.out.println("Traditional: " + traditionalResult);

        // Java 16: Stream.toList()
        List<String> newResult = names.stream()
                .filter(name -> name.length() > 3)
                .toList();
        System.out.println("Stream.toList(): " + newResult);

        // The returned list is unmodifiable
        // newResult.add("JavaScript"); // Throws UnsupportedOperationException
    }
}