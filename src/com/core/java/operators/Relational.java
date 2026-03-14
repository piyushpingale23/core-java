package com.core.java.operators;

import java.util.Scanner;

public class Relational {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter 'a' element -> ");
        int a = sc.nextInt();

        System.out.print("Enter 'b' element -> ");
        int b = sc.nextInt();

        System.out.println("== : " + (a == b));
        System.out.println("!= : " + (a != b));
        System.out.println(">= : " + (a >= b));
        System.out.println("<= : " + (a <= b));
        System.out.println("> : " + (a > b));
        System.out.println("< : " + (a < b));
    }
}
