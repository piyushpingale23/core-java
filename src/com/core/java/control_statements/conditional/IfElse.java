package com.core.java.control_statements.conditional;

import java.util.Scanner;

public class IfElse {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number -> ");
        int number = sc.nextInt();

        if(number % 2 == 0) {
            System.out.println("Even Number");
        } else {
            System.out.println("Odd Number");
        }
    }
}
