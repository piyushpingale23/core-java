package com.core.java.final_keyword;

/**
 * Concept: final class <br>
 * <br>
 * - A class declared with 'final' keyword CANNOT be inherited (extended). <br>
 * <br>
 * ----------------------------- <br>
 * Why use final class? <br>
 * <br>
 * - To prevent modification of class behavior <br>
 * - For security (e.g., String class in Java is final) <br>
 * - To make class immutable / fixed <br>
 * <br>
 * ----------------------------- <br>
 * Key Points: <br>
 * <br>
 * 1. final class: <br>
 *    - Cannot be extended <br>
 *    - No subclass can be created <br>
 * <br>
 * 2. All methods in final class are indirectly safe from overriding <br>
 *    (because inheritance itself is not allowed) <br>
 * <br>
 * -----------------------------
 */

// Final class
final class Parent1 {

    void show() {
        System.out.println("Final class method");
    }
}

/*
 * NOT ALLOWED
 *
 * class Child extends Parent {
 * }
 *
 * Compile-time error:
 * "Cannot inherit from final 'Parent'"
 *
 */

public class FinalKeyword5 {

    public static void main(String[] args) {

        Parent1 p = new Parent1();
        p.show();

    }
}