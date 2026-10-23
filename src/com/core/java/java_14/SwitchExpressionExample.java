package com.core.java.java_14;


/*
 * Java 14 Feature: Switch Expressions
 *
 * Traditional switch:
 * - Uses case, break, and a separate variable to store the result.
 * - Without break, execution may fall through to the next case.
 *
 * Switch expression (Java 14):
 * - Returns a value directly and can assign it to a variable.
 * - Uses -> instead of : to avoid accidental fall-through.
 * - Multiple case labels can be combined using commas.
 * - yield returns a value from a multi-statement switch block.
 * - Switch expressions became permanent in Java 14 (JEP 361).
 */

import java.util.Scanner;

public class SwitchExpressionExample {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter day: " );
        int day = sc.nextInt();

        // Traditional switch statement
        String traditionalResult;

        switch (day) {
            case 1:
                traditionalResult = "Monday";
                break;
            case 2:
                traditionalResult = "Tuesday";
                break;
            default:
                traditionalResult = "Invalid day";
        }

        System.out.println("Traditional: " + traditionalResult);

        // Switch expression: returns a value directly
        String newResult = switch (day) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            default -> "Invalid day";
        };

        System.out.println("Switch expression: " + newResult);

        // Multiple case labels
        String dayType = switch (day) {
            case 1, 2, 3, 4, 5 -> "Weekday";
            case 6, 7 -> "Weekend";
            default -> "Invalid day";
        };

        System.out.println("Day type: " + dayType);
    }
}

/*
 * Output:
 *
 * Traditional: Monday
 * Switch expression: Monday
 * Day type: Weekday
 * Number is 10
 * Number name: Ten
 */

