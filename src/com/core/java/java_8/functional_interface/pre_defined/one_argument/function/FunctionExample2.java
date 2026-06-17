package com.core.java.java_8.functional_interface.pre_defined.one_argument.function;

import java.util.function.Function;

// Write a Function that takes a String as input
// and returns the number of characters in the String.
public class FunctionExample2 {

    public static void main(String[] args) {

        Function<String, Integer> function1 = s -> s.length();
        Function<String, String> function2 = s -> s.toUpperCase();

        System.out.println("Length of String: " + function1.apply("function_example"));
        System.out.println("Uppercase of String: " + function2.apply("function_example"));

    }
}
