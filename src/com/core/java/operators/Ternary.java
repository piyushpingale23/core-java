package com.core.java.operators;

import java.util.Scanner;

public class Ternary {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter age -> ");
        int age = sc.nextInt();

        String result = (age >= 18) ? "Eligible" : "Not Eligible";
        System.out.println(result);
    }
}
