package com.core.java.operators;

import java.util.Scanner;

public class Logical {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter age -> ");
        int age = sc.nextInt();

        System.out.println(age > 18 && age < 30);
        System.out.println(age > 18 || age < 10);
        System.out.println(!(age > 18));
    }
}
