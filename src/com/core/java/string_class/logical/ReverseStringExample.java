package com.core.java.string_class.logical;

import java.util.Scanner;

public class ReverseStringExample {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter String -> " );
        String s = sc.nextLine();

        String s1 = "";

        for (int i = s.length() - 1; i >= 0; i--) {
            s1 = s1 + s.charAt(i);
        }

//         OR
//        StringBuffer sb = new StringBuffer(s);
//        System.out.println(sb.reverse());

        System.out.println("Reversed String -> " + s1);
    }
}
