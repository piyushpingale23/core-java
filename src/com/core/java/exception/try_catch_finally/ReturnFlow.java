package com.core.java.exception.try_catch_finally;

public class ReturnFlow {

    public static void main(String[] args) {
        System.out.println(test());
    }

    static int test() {
        try {
            int x = 10 / 0;
            return 1;
        } catch (Exception e) {
            return 2;
        } finally {
            System.out.println("Finally executed");
        }
    }
}
