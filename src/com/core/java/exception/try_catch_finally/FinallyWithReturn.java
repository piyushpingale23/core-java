package com.core.java.exception.try_catch_finally;

public class FinallyWithReturn {

    public static void main(String[] args) {
        System.out.println(test());
    }

    static int test() {
        try {
            System.out.println("in try");
            return 1;
        } finally {
            System.out.println("in finally");
            return 2;
        }
    }
}
