package com.core.java.string_class.logical;

import java.util.Scanner;

public class RemoveSpacesExample {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter sentence -> " );
        String s = sc.nextLine();

        String result = s.replace(" ", "");

        System.out.println(result);
    }
}
