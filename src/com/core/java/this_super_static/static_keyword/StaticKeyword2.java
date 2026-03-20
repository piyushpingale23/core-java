package com.core.java.this_super_static.static_keyword;

import java.util.Scanner;

// Static Method (Utility Method)
public class StaticKeyword2 {

    static int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a -> " );
        int a = sc.nextInt();

        System.out.print("Enter b -> " );
        int b = sc.nextInt();

        System.out.println("Total -> " + StaticKeyword2.add(a, b));
    }
}
