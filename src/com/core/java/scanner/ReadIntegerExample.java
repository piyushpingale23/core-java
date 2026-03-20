package com.core.java.scanner;

import java.util.Scanner;

public class ReadIntegerExample {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number -> ");
        int number = scanner.nextInt();

        System.out.println("Number is: " + number);

        scanner.close();
    }
}