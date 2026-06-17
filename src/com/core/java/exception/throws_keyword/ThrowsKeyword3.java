package com.core.java.exception.throws_keyword;

public class ThrowsKeyword3 {

    public static void main(String[] args) {

        try {
            method1();
        } catch (Exception e) {
            System.out.println("Handled in main");
        }
    }

    static void method1() throws Exception {
        method2();
        // (Exception is not handled here -> propagated to caller)
    }

    static void method2() throws Exception {
        throw new Exception("Error in method2");
        // (Actual exception thrown here)
    }

}
