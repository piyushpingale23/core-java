package com.core.java.scanner;

import java.util.Scanner;

public class ReadStringExample {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sentence -> ");

        String text = scanner.nextLine();

        System.out.println("You entered: " + text);

        scanner.close();
    }
}