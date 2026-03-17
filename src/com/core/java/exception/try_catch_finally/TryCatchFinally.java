package com.core.java.exception.try_catch_finally;

public class TryCatchFinally {

    public static void main(String[] args) {

        try {
            int x = 10 / 0;
            System.out.println("try");
        } catch (Exception e) {
            System.out.println("catch");
        } finally {
            System.out.println("finally");
        }
    }
}