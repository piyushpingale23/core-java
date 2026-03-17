package com.core.java.exception.custom.compiletime;

import java.util.Scanner;

public class ThrowsKeyword {

    public static void main(String[] args) throws CustomCompileTimeException {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter age : ");
        int age = sc.nextInt();

        validateAge (age);
    }

    private static void validateAge(int age) {

        System.out.println("Age : " + age);
    }
}
