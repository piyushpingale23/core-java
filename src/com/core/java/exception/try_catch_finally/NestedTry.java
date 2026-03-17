package com.core.java.exception.try_catch_finally;

import java.util.Scanner;

public class NestedTry {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Enter your age: ");
            int age = sc.nextInt();

            try {
                if (age < 18) {
                    throw new IllegalArgumentException("Age must be 18+");
                }

                System.out.print("Enter a number to divide 100: ");
                int num = sc.nextInt();

                int result = 100 / num;

                System.out.println("Result: " + result);

            } catch (IllegalArgumentException e) {
                System.out.println("Inner catch: " + e.getMessage());

            } catch (ArithmeticException e) {
                System.out.println("Inner catch: Cannot divide by zero");

            } finally {
                System.out.println("Inner finally: Always executes");
            }

        } catch (Exception e) {
            System.out.println("Outer catch: Invalid input");

        } finally {
            System.out.println("Outer finally: (Resource closed)");
        }
    }
}
