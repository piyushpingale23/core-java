package com.core.java.exception.throws_keyword;

import java.io.FileReader;
import java.io.IOException;

public class ThrowsKeyword2 {

    public static void main(String[] args) throws IOException {

        process();
//        try {
//            process();
//        } catch (IOException | ArithmeticException e) {
//            System.out.println("Handled: " + e);
//        }
    }

    static void process() throws IOException {
        // (Declaring multiple exceptions)

        FileReader file = new FileReader("throwKeyword2.txt"); // IOException

        int x = 10 / 0; // ArithmeticException

    }
}
