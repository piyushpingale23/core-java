package com.core.java.java_8.functional_interface.pre_defined.two_argument.bifunction;

import java.util.function.BiFunction;

// Write a BiFunction to calculate the total length of two given Strings.
public class BiFunctionExample1 {

    public static void main(String[] args) {

        BiFunction<String, String, Integer> biFunction = (a, b) -> (a.length()) + (b.length());
        System.out.println(biFunction.apply("java", "python"));

    }
}
