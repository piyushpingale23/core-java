package com.core.java.controlstatements.conditional;

import java.util.Scanner;

public class NestedIf {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter age -> ");
        int age = sc.nextInt();

        boolean hasLicense = true;
        if(age >= 18) {
            System.out.println("Allowed to drive");
        }
    }
}
