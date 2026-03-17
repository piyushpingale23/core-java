package com.core.java.exception.try_catch_finally;

public class FinallyModify {

    public static void main(String[] args) {

        int value = 10;
        System.out.println("Actual value : " + value);

        try {
            value = 20;
            System.out.println("Value in try : " + value);
        } finally {
            value = 30;
            System.out.println("Value in finally : " + value);
        }

        System.out.println("Final value : " + value);
    }
}
