package com.core.java.java_8.functional_interface;

// Multithreading using Functional Interface (Runnable)
// Problem Statement:
// Create a child thread using lambda expression and run it parallel with main thread
public class FunctionalInterface2 {

    public static void main(String[] args) {

        // -------------------------------
        // Child Thread logic using Lambda
        // Runnable is a functional interface
        // -------------------------------
        Runnable runnable = () -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println("Child Thread .....");
            }
        };

        // Thread creation using Runnable
        Thread thread = new Thread(runnable);
        thread.start(); // starts child thread execution

        // -------------------------------
        // Main Thread execution
        // -------------------------------
        for (int i = 1; i <= 10; i++) {
            System.out.println("Main Thread .....");
        }
    }
}