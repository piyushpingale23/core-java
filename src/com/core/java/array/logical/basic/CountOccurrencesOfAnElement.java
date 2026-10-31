package com.core.java.array.logical.basic;

import java.util.Scanner;

// Problem: Count Occurrences of an Element in an Array
public class CountOccurrencesOfAnElement {

    public static void main(String[] args) {

        int[] array = {1, 3, 2, 4, 2, 1, 1, 2};

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter target element: ");
        int target = sc.nextInt();

        int targetCount = 0;
        for (int i = 0; i < array.length; i++) {
            if (target == array[i]) {
                targetCount ++;
            }
        }
        System.out.println(target + " element occurred " + targetCount + " times.");

    }
}
