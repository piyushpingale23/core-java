package com.core.java.java_8.functional_interface.pre_defined.one_argument.predicate;

import java.util.function.Predicate;

// Write a Predicate to check whether length of String is >5 or not.
public class PredicateExample2 {

    public static void main(String[] args) {

        Predicate<String> predicate = s -> s.length() > 5;

        System.out.println(predicate.test("predicate_example"));
        System.out.println(predicate.test("abc"));

    }


}
