package com.core.java.controlstatements.conditional;

import java.util.Scanner;

/**
 * This example demonstrates the concept of Switch Fall-Through in Java. <br>
 * <br>
 * Fall-through occurs when a 'break' statement is not used in a case block. <br>
 * When this happens, execution continues to the next case even if the case <br>
 * value does not match the switch expression. <br>
 * <br>
 * This behavior can be useful when multiple cases should execute the same code.
 */
public class SwitchFallThrough {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number (1-3) -> ");
        int number = sc.nextInt();

        switch (number) {

            case 1:
                System.out.println("Case 1 executed");
                break;

            case 2:
                System.out.println("Case 2 executed");

            case 3:
                System.out.println("Case 3 executed");
                break;

            default:
                System.out.println("Invalid input");
        }

        sc.close();
    }
}
