package com.core.java.java_8.functional_interface.pre_defined.one_argument.predicate;

import java.util.function.Predicate;

public class PredicateMethodsExample {

    public static void main(String[] args) {

        int[] array = {2, 45, 6, 11, 79, 0, 66, 43};

        // Checks whether the number is even
        Predicate<Integer> isEven = i -> i % 2 == 0;

        // Checks whether the number is >= 50
        Predicate<Integer> greaterThanOrEqualTo50 = i -> i >= 50;

        // =====================================================
        // AND
        // =====================================================
        System.out.println("=== Predicate AND Example ===");
        System.out.println("Condition: Number must be EVEN and >= 50");

        Predicate<Integer> andPredicate = isEven.and(greaterThanOrEqualTo50);

        for (int i : array) {
            if (andPredicate.test(i)) {
                System.out.println(i);
            }
        }

        // =====================================================
        // OR
        // =====================================================
        System.out.println("\n=== Predicate OR Example ===");
        System.out.println("Condition: Number must be EVEN or >= 50");

        Predicate<Integer> orPredicate = isEven.or(greaterThanOrEqualTo50);

        for (int i : array) {
            if (orPredicate.test(i)) {
                System.out.println(i);
            }
        }

        // =====================================================
        // NEGATE (NOT)
        // =====================================================
        System.out.println("\n=== Predicate NEGATE Example ===");
        System.out.println("Condition: Number must NOT be EVEN");

        Predicate<Integer> notEvenPredicate = isEven.negate();

        for (int i : array) {
            if (notEvenPredicate.test(i)) {
                System.out.println(i);
            }
        }

        // =====================================================
        // isEqual
        // =====================================================
        System.out.println("\n=== Predicate isEqual Example ===");
        System.out.println("Condition: Number must be equal to 45");

        Predicate<Integer> equalPredicate = Predicate.isEqual(45);

        for (int i : array) {
            if (equalPredicate.test(i)) {
                System.out.println(i);
            }
        }
    }
}