package com.core.java.string_class.logical;

import java.util.List;

public class FindMissingNumber {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 8);

        int targetSum = 8 * (8 + 1) / 2;
        System.out.println("Target Sum: " + targetSum);

        int actualSum = 0;

        for (Integer i : numbers) {
            actualSum += i;
        }

        System.out.println("Actual Sum: " + actualSum);
        System.out.println("Missing number: " + (targetSum - actualSum));

    }

}
