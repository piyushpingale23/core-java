package com.core.java.java_8.functional_interface.pre_defined.two_argument.bipredicate;

import java.util.function.BiPredicate;

// Write a BiPredicate to check sum of 2 numbers even or not.
public class BiPredicateExample1 {

    public static void main(String[] args) {

        BiPredicate<Integer, Integer> biPredicate = (a,b) -> (a+b) %2 == 0;
        System.out.println(biPredicate.test(10, 15));

    }
}
