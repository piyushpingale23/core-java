package com.core.java.java_8.functional_interface.pre_defined.one_argument.predicate;

import java.util.function.Predicate;

public class PredicateExample1 {

    public static void main(String[] args) {

        // Predicate<T> is used when:
        // Input  -> Some object/value
        // Output -> boolean (true/false)

        // Here T = Integer
        // This lambda expression provides the implementation
        // of the test() method.
        Predicate<Integer> isEven = n -> n % 2 == 0;

        // Calls test(10)
        // 10 % 2 == 0 -> true
        System.out.println(isEven.test(10));

        // Calls test(11)
        // 11 % 2 == 0 -> false
        System.out.println(isEven.test(11));
    }
}

class TraditionalExample {

    // Traditional method that accepts an integer
    // and returns true if the number is even,
    // otherwise returns false.
    public static boolean isEven(int n) {
        return n % 2 == 0;
    }

    public static void main(String[] args) {

        // Method call
        // isEven(10) -> true
        System.out.println(isEven(10));

        // Method call
        // isEven(11) -> false
        System.out.println(isEven(11));
    }
}