package com.core.java.exception.try_catch_finally;

public class FinallyWithReturn {

    public static void main(String[] args) {
        System.out.println(test());
    }

    static int test() {
        try {
            return 1;
        } finally {
            return 2;
        }
    }
}
