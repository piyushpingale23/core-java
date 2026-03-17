package com.core.java.exception.try_catch_finally;

public class TryCatchOnly {

    public static void main(String[] args) {

        try {
            int x = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Caught exception");
        }
    }
}
