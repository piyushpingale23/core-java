package com.core.java.exception.custom.runtime;

import java.util.Scanner;

public class ThrowKeyword {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter age : ");
        int age = sc.nextInt();

        try {
            validateAge (age);
        } catch (CustomRuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void validateAge (int age) {

        if (age < 18) {
            throw new CustomRuntimeException("Age is less than 18");
        }
        System.out.println("Age is more than 18");

    }
}
