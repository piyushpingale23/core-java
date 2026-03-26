package com.core.java.string_class.logical;

import java.util.Scanner;

public class PalindromeExample {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter String -> " );
        String s = sc.nextLine();
        String s1 = "";

        for (int i = s.length() - 1; i >= 0; i--) {
            s1 = s1 + s.charAt(i);
        }

        if (s.equals(s1)) {
            System.out.println("Entered string (" + s + ") is Palindrome");
        } else {
            System.out.println("Entered string (" + s + ") is not Palindrome");
        }
    }
}
