package com.core.java.exception.try_catch_finally;

public class NoExceptionCase {

    public static void main(String[] args) {

        try {
            System.out.println("No exception here");
        } catch (Exception e) {
            System.out.println("Won't execute");
        } finally {
            System.out.println("Still executes");
        }
    }
}
