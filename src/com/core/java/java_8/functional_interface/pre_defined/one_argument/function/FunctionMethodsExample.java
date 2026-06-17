package com.core.java.java_8.functional_interface.pre_defined.one_argument.function;

import java.util.function.Function;

// Demonstrate Function interface methods:
// apply(), andThen(), compose(), and identity()
public class FunctionMethodsExample {

    public static void main(String[] args) {

        // Function to find square of a number
        Function<Integer, Integer> square = n -> n * n;

        // Function to double a number
        Function<Integer, Integer> doubleIt = n -> n * 2;

        // =====================================================
        // apply()
        // =====================================================
        System.out.println("=== apply() Example ===");
        System.out.println("Square of 5: " + square.apply(5));

        // =====================================================
        // andThen()
        // First square the number, then double the result
        // =====================================================
        System.out.println("\n=== andThen() Example ===");

        int andThenResult = square.andThen(doubleIt).apply(5);

        System.out.println("Execution Flow:");
        System.out.println("square(5)    = 25");
        System.out.println("doubleIt(25) = 50");
        System.out.println("Result       = " + andThenResult);

        // =====================================================
        // compose()
        // First double the number, then square the result
        // =====================================================
        System.out.println("\n=== compose() Example ===");

        int composeResult = square.compose(doubleIt).apply(5);

        System.out.println("Execution Flow:");
        System.out.println("doubleIt(5) = 10");
        System.out.println("square(10)  = 100");
        System.out.println("Result      = " + composeResult);

        // =====================================================
        // identity()
        // Returns the same object that is passed as input
        // =====================================================
        System.out.println("\n=== identity() Example ===");

        Function<String, String> identity = Function.identity();

        System.out.println("Input  : Piyush");
        System.out.println("Output : " + identity.apply("Piyush"));
    }
}