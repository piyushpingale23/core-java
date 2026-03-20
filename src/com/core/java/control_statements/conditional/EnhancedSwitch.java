package com.core.java.control_statements.conditional;

import java.util.Scanner;

/**
 * This example demonstrates the Enhanced Switch statement in Java. <br>
 * <br>
 * Enhanced switch uses the arrow (->) syntax instead of traditional <br>
 * case blocks and does not require a break statement. <br>
 * <br>
 * It makes the switch statement shorter, cleaner, and less error-prone.
 */
public class EnhancedSwitch {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter day number (1-7) -> ");
        int day = sc.nextInt();

        switch (day) {

            case 1 -> System.out.println("Monday");

            case 2 -> System.out.println("Tuesday");

            case 3 -> System.out.println("Wednesday");

            case 4 -> System.out.println("Thursday");

            case 5 -> System.out.println("Friday");

            case 6, 7 -> System.out.println("Weekend");

            default -> System.out.println("Invalid day");
        }

        sc.close();
    }
}
