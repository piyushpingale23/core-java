package com.core.java.oops.polymorphism.overloading;

public class OverloadingExample4 {

    void m1(int i, float f) {
        System.out.println("int: " + i + " & float: " + f);
    }

    void m1(float f, int i) {
        System.out.println("float: " + f + " & int: " + i);
    }

    public static void main(String[] args) {

        OverloadingExample4 ol4 = new OverloadingExample4();

        // Case 1:
        // (int, float) → exact match with first method
        ol4.m1(10, 20.1f);

        // Case 2:
        // (float, int) → exact match with second method
        ol4.m1(10.1f, 20);

        // Case 3:
        // (int, int)
        // NO exact match available
        // Java tries type promotion:
        // int -> float OR int → int (both directions possible)
        // compiler confusion → AMBIGUITY ERROR
        // ol4.m1(10, 20);

        // Case 4:
        // (float, float)
        // NO exact match available
        // float -> int (narrowing not allowed automatically)
        // AMBIGUITY ERROR
        // ol4.m1(10.1f, 20.2f);
    }
}