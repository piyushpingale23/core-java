package com.core.java.string_class.logical;

import java.util.Scanner;

public class ReverseWordOrderExample {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter sentence -> ");
        String s = sc.nextLine();

        String reverseWordOrder = "";
        String[] sArray = s.split(" ");
        for (int i = sArray.length - 1; i >= 0; i--) {
            reverseWordOrder = reverseWordOrder.concat(sArray[i] + " ");
        }
        System.out.println(reverseWordOrder);
    }
}
