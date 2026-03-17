package com.core.java.exception.throw_keyword;

import java.util.Scanner;

// Case: Thrown runtime exception -> handle by caller method (main()) -> program terminates normally.
public class ThrowKeyword2 {

    public static void main(String[] args) {

        try {

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter age : ");
            int age = sc.nextInt();

            validateAge(age);

        } catch (Exception e) {
            System.out.println("Exception Caught: " + e.getMessage());
        }

        System.out.println("Program continues...");
    }

    private static void validateAge(int age) {

        if (age < 18) {
            throw new ArithmeticException("Underage");
        }

        System.out.println("Valid age");
    }
}
