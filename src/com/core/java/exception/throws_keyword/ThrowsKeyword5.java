package com.core.java.exception.throws_keyword;

import java.io.FileReader;

// Case: throws an unchecked exception
public class ThrowsKeyword5 {

    public static void main(String[] args) {

        try {
            validate();
        } catch (Exception e) {
            System.out.println("Exception handled: " + e.getMessage());
        }

    }

    private static void validate() throws ArithmeticException {

        int i = 10 / 0;

    }
}
