package com.core.java.java_8.functional_interface.pre_defined.one_argument.consumer;

import java.util.function.Consumer;

// Demonstrate Consumer methods:
// 1. accept()
// 2. andThen()
public class ConsumerMethodsExample {

    public static void main(String[] args) {

        // Consumer 1: Print the number
        Consumer<Integer> printNumber = number -> System.out.println("Number : " + number);

        // Consumer 2: Print square of the number
        Consumer<Integer> printSquare = number -> System.out.println("Square : " + (number * number));

        System.out.println("=== accept() Example ===");

        printNumber.accept(10);

        System.out.println("\n=== andThen() Example ===");

        printNumber.andThen(printSquare).accept(10);
    }
}