package com.core.java.java_8.functional_interface.pre_defined.two_argument.bipredicate;

import java.util.function.BiPredicate;

// Write a BiPredicate to check whether the length of a String
// matches the given Integer value.
public class BiPredicateExample2 {

    public static void main(String[] args) {

        BiPredicate<String, Integer> biPredicate = (a,b) -> a.length() == b;
        System.out.println(biPredicate.test("bi_predicate", 11));

    }
}
