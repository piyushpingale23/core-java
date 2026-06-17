package com.core.java.java_8.stream_api;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TerminalStreamExample {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("A", "B", "C", "D", "E");

        // =====================================================
        // forEach()
        // Consumes each element and performs an action.
        // =====================================================
        names.stream()
                .forEach(System.out::println);

        System.out.println("--------------------");


        // =====================================================
        // count()
        // Returns total number of elements.
        // =====================================================
        long count = names.stream().count();

        System.out.println("Count = " + count);

        System.out.println("--------------------");


        // =====================================================
        // toList()
        // Collects stream elements into a List.
        // =====================================================
        List<String> upperCaseNames = names.stream()
                .map(String::toUpperCase)
                .toList();

        System.out.println(upperCaseNames);

        System.out.println("--------------------");


        // =====================================================
        // collect()
        // Performs mutable reduction operation.
        // Used for List, Set, Map, Grouping etc.
        // =====================================================
        Map<Integer, List<String>> groupedNames =
                names.stream()
                        .collect(Collectors.groupingBy(String::length));

        System.out.println(groupedNames);

        System.out.println("--------------------");


        // =====================================================
        // reduce()
        // Combines all elements into a single result.
        // =====================================================
        int sum = List.of(10, 20, 30, 40, 50)
                .stream()
                .reduce(0, Integer::sum);

        System.out.println("Sum = " + sum);

        System.out.println("--------------------");


        // =====================================================
        // findFirst()
        // Returns first element as Optional.
        // =====================================================
        names.stream()
                .findFirst()
                .ifPresent(System.out::println);

        System.out.println("--------------------");


        // =====================================================
        // findAny()
        // Returns any element (useful in parallel streams).
        // =====================================================
        names.stream()
                .findAny()
                .ifPresent(System.out::println);

        System.out.println("--------------------");


        // =====================================================
        // anyMatch()
        // Returns true if at least one element matches.
        // =====================================================
        boolean anyMatch = names.stream()
                .anyMatch(name -> name.startsWith("P"));

        System.out.println(anyMatch);

        System.out.println("--------------------");


        // =====================================================
        // allMatch()
        // Returns true if all elements match.
        // =====================================================
        boolean allMatch = names.stream()
                .allMatch(name -> name.length() > 2);

        System.out.println(allMatch);

        System.out.println("--------------------");


        // =====================================================
        // noneMatch()
        // Returns true if no element matches.
        // =====================================================
        boolean noneMatch = names.stream()
                .noneMatch(name -> name.startsWith("Z"));

        System.out.println(noneMatch);

        System.out.println("--------------------");


        // =====================================================
        // min()
        // Returns minimum element.
        // =====================================================
        List<Integer> numbers =
                Arrays.asList(10, 5, 30, 2, 50);

        numbers.stream()
                .min(Integer::compareTo)
                .ifPresent(System.out::println);

        System.out.println("--------------------");


        // =====================================================
        // max()
        // Returns maximum element.
        // =====================================================
        numbers.stream()
                .max(Integer::compareTo)
                .ifPresent(System.out::println);

        System.out.println("--------------------");


        // =====================================================
        // toArray()
        // Converts stream into array.
        // =====================================================
        Object[] array =
                names.stream().toArray();

        System.out.println(Arrays.toString(array));
    }
}

//        | Terminal Operation | Purpose                         |
//        | ------------------ | ------------------------------- |
//        | `forEach()`        | Perform action on each element  |
//        | `count()`          | Count elements                  |
//        | `toList()`         | Convert stream to List          |
//        | `collect()`        | Collect into List/Set/Map/Group |
//        | `reduce()`         | Aggregate into single value     |
//        | `findFirst()`      | Get first element               |
//        | `findAny()`        | Get any element                 |
//        | `anyMatch()`       | At least one match              |
//        | `allMatch()`       | All elements match              |
//        | `noneMatch()`      | No element matches              |
//        | `min()`            | Smallest element                |
//        | `max()`            | Largest element                 |
//        | `toArray()`        | Convert to array                |

