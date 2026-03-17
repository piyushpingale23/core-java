package com.core.java.exception.try_catch_finally;

public class CatchNotMatching {

    public static void main(String[] args) {

        try {

            String s = null;
            int x = s.length();

        } catch (ArithmeticException e) {
            System.out.println("This won't catch");
        }
    }
}

// output -> Program will crash (no matching catch)
