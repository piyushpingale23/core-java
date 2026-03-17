package com.core.java.exception.throws_keyword;

import java.io.FileReader;
import java.io.IOException;

public class ThrowsKeyword2 {

    public static void main(String[] args) {

        try {
            process();
        } catch (IOException | ArithmeticException e) {
            System.out.println("Handled: " + e);
        }
    }

    static void process() throws IOException, ArithmeticException {
        // (Declaring multiple exceptions)

        FileReader file = new FileReader("abc.txt"); // IOException

        int x = 10 / 0; // ArithmeticException

    }
}
