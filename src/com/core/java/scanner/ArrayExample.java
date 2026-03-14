package com.core.java.scanner;

import java.util.Scanner;
import java.util.Arrays;

public class ArrayExample {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Ask user for array size
        System.out.print("Enter number of elements -> ");
        int size = scanner.nextInt();

        int[] numbers = new int[size];

        // Taking input from user
        System.out.print("Enter " + size + " numbers -> ");

        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextInt();
        }

        // Printing array using loop
        System.out.println("Array elements:");

        for (int number : numbers) {
            System.out.println(number);
        }

        // Printing array using Arrays class
        System.out.println("Array using Arrays.toString():");
        System.out.println(Arrays.toString(numbers));

        scanner.close();
    }
}