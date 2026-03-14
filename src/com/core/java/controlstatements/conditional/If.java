package com.core.java.controlstatements.conditional;

import java.util.Scanner;

public class If {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter age -> ");
        int age = sc.nextInt();

        if(age >= 18) {
            System.out.println("Eligible to vote");
        }
    }
}
