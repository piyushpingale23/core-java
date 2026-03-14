package com.core.java.scanner;

import java.util.Scanner;

public class ScannerExample {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name -> ");

        String name = scanner.nextLine();

        System.out.println("Hello " + name);

        scanner.close();
    }
}