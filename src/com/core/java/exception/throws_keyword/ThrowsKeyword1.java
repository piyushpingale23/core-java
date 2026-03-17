package com.core.java.exception.throws_keyword;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ThrowsKeyword1 {

    public static void main(String[] args) {

        try {
            readFile();
        } catch (IOException e) {
            System.out.println("Handled: " + e.getMessage());
        }
    }

    static void readFile() throws IOException {

        FileReader file = new FileReader("test.txt");
        // (If file not found → IOException)

        BufferedReader br = new BufferedReader(file);
        System.out.println(br.readLine());
    }
}
