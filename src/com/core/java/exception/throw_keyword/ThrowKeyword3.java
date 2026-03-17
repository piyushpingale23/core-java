package com.core.java.exception.throw_keyword;

import java.io.IOException;

// Case: throw compile time exception -> handle by caller method (main()) -> program terminates normally.
public class ThrowKeyword3 {

    public static void main(String[] args) {
        try {
            checkFile();
        } catch (IOException e) {
            System.out.println("Handled: " + e.getMessage());
        }
    }

//    public static void main(String[] args) throws IOException {
//        checkFile();
//    }

    static void checkFile() throws IOException {
        throw new IOException("File not found");
    }
}
