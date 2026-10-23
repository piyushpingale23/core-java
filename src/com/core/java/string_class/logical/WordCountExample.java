package com.core.java.string_class.logical;

import java.util.Scanner;

public class WordCountExample {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter sentence -> " );
        String s = sc.nextLine();

        int count = 1;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == ' ') {
                count++;
            }
        }

        String[] sArray = s.split(" ");

        System.out.println("Word count = " + count);
        System.out.println("Word count = " + sArray.length);


//        String[] words = s.trim().split("\\s+");
//        System.out.println("Word count = " + words.length);

    }
}
