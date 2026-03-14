package com.core.java.operators;

import java.util.Scanner;

public class Assignment {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter value for 'a' -> ");
        int a = sc.nextInt();

        System.out.print("Enter value for 'b' -> ");
        int b = sc.nextInt();

        int result;

        // = operator
        result = a;
        System.out.println("=  : result = " + result);

        // += operator
        result += b;
        System.out.println("+= : " + result);

        // -= operator
        result = a;
        result -= b;
        System.out.println("-= : " + result);

        // *= operator
        result = a;
        result *= b;
        System.out.println("*= : " + result);

        // /= operator
        result = a;
        result /= b;
        System.out.println("/= : " + result);

        // %= operator
        result = a;
        result %= b;
        System.out.println("%= : " + result);
    }
}