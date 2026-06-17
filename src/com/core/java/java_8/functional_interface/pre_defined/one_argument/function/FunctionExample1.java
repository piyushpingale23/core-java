package com.core.java.java_8.functional_interface.pre_defined.one_argument.function;

import java.util.function.Function;

// Write a Function that accepts an Integer as input
// and returns the square of that number.
public class FunctionExample1 {

    public static void main(String[] args) {

        Function<Integer, Integer> function = i -> i * i;
        System.out.println(function.apply(10));

    }
}
