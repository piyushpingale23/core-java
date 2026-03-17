package com.core.java.exception.throws_keyword;

public class ThrowsKeyword4 {

    public static void main(String[] args) throws Exception {
        // (main() also declares → JVM will handle if not caught)
        // abnormal termination

        test();
    }

    static void test() throws Exception {
        throw new Exception("Unhandled exception");
        // (No try-catch anywhere → JVM default handler)
    }
}
