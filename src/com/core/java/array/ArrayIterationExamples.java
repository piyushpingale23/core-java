package com.core.java.array;

import java.util.Arrays;

public class ArrayIterationExamples {

    public static void main(String[] args) {

        Integer[] array = {1, 2, 3, 4, 5};

        // 1. Enhanced for loop
        System.out.println("1. Enhanced for loop:");
        for (Integer number : array) {
            System.out.println(number);
        }

        // 2. Arrays.asList().forEach()
        System.out.println("\n2. Arrays.asList().forEach():");
        Arrays.asList(array).forEach(System.out::println);

        // 3. Arrays.stream().forEach() for Integer[]
        System.out.println("\n3. Arrays.stream().forEach():");
        Arrays.stream(array).forEach(System.out::println);

        // 4. Traditional for loop
        System.out.println("\n4. Traditional for loop:");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        // 5. Primitive int[] using Arrays.stream().forEach()
        System.out.println("\n5. Primitive int[] with stream:");
        int[] primitiveArray = {10, 20, 30, 40, 50};

        Arrays.stream(primitiveArray).forEach(System.out::println);

        // 6. Primitive int[] using enhanced for loop
        System.out.println("\n6. Primitive int[] with enhanced for loop:");
        for (int number : primitiveArray) {
            System.out.println(number);
        }

        // Note: array.forEach() is not supported directly.
        // array.forEach(number -> System.out.println(number)); // Compilation error
    }
}
