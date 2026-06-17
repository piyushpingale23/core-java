package com.core.java.exception.throw_keyword;

// Case: Exception Propagation (No Handling)
public class ThrowKeyword4 {

    public static void main(String[] args) {

        method1();
        // (No try-catch -> JVM will handle)
    }

    static void method1() {
        method2();
    }

    static void method2() {
        throw new RuntimeException("Error occurred");
        // (Exception propagates -> main -> JVM default handler)
    }
}
