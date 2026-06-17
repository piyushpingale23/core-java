package com.core.java.java_8.date_time;

import java.time.Year;
import java.util.Scanner;

public class YearExample {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Year : " );
        int n = sc.nextInt();

        Year year = Year.of(n);

        if (year.isLeap()) {
            System.out.println(n + " is Leap Year.");
        } else {
            System.out.println(n + " is not Leap Year.");
        }
    }
}
