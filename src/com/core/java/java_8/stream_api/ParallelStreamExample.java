package com.core.java.java_8.stream_api;

import java.util.Arrays;
import java.util.List;

public class ParallelStreamExample {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // =====================================================
        // parallelStream()
        // Processes elements using multiple threads.
        // =====================================================
        numbers.parallelStream()
                .forEach(num ->
                        System.out.println(
                                Thread.currentThread().getName()
                                        + " -> " + num));

        System.out.println("--------------------");


        // =====================================================
        // stream().parallel()
        // Converts a normal stream into a parallel stream.
        // =====================================================
        numbers.stream()
                .parallel()
                .forEach(num ->
                        System.out.println(
                                Thread.currentThread().getName()
                                        + " -> " + num));

        System.out.println("--------------------");


        // =====================================================
        // Parallel + map()
        // Multiple threads transform data simultaneously.
        // =====================================================
        numbers.parallelStream()
                .map(num -> {
                    System.out.println(
                            Thread.currentThread().getName()
                                    + " Processing " + num);
                    return num * 10;
                })
                .forEach(System.out::println);

        System.out.println("--------------------");


        // =====================================================
        // Parallel + filter()
        // Multiple threads evaluate conditions.
        // =====================================================
        numbers.parallelStream()
                .filter(num -> {
                    System.out.println(
                            Thread.currentThread().getName()
                                    + " Checking " + num);
                    return num % 2 == 0;
                })
                .forEach(System.out::println);

        System.out.println("--------------------");


        // =====================================================
        // Parallel + reduce()
        // Partial results are computed in parallel and merged.
        // =====================================================
        int sum = numbers.parallelStream()
                .reduce(0, Integer::sum);

        System.out.println("Sum = " + sum);

        System.out.println("--------------------");


        // =====================================================
        // Parallel + count()
        // Counting elements using parallel processing.
        // =====================================================
        long count = numbers.parallelStream()
                .count();

        System.out.println("Count = " + count);

        System.out.println("--------------------");


        // =====================================================
        // forEach()
        // Order is NOT guaranteed in parallel streams.
        // =====================================================
        numbers.parallelStream()
                .forEach(System.out::println);

        System.out.println("--------------------");


        // =====================================================
        // forEachOrdered()
        // Maintains encounter order even in parallel streams.
        // =====================================================
        numbers.parallelStream()
                .forEachOrdered(System.out::println);

        System.out.println("--------------------");


        // =====================================================
        // findAny()
        // Returns any available element quickly.
        // Optimized for parallel processing.
        // =====================================================
        numbers.parallelStream()
                .findAny()
                .ifPresent(System.out::println);

        System.out.println("--------------------");


        // =====================================================
        // findFirst()
        // Returns first element.
        // May reduce parallel performance because order matters.
        // =====================================================
        numbers.parallelStream()
                .findFirst()
                .ifPresent(System.out::println);
    }
}

//        | Method                | Purpose                                  |
//        | --------------------- | ---------------------------------------- |
//        | `parallelStream()`    | Creates a parallel stream                |
//        | `stream().parallel()` | Converts normal stream to parallel       |
//        | `forEach()`           | Parallel execution, order not guaranteed |
//        | `forEachOrdered()`    | Maintains original order                 |
//        | `map()`               | Parallel transformation                  |
//        | `filter()`            | Parallel filtering                       |
//        | `reduce()`            | Parallel aggregation                     |
//        | `count()`             | Parallel counting                        |
//        | `findAny()`           | Returns any available element quickly    |
//        | `findFirst()`         | Returns first element (order maintained) |
