package com.core.java.final_keyword;

/** <br>
 * Concept: final method <br>
 * <br>
 * - A method declared with 'final' keyword CANNOT be overridden in subclass. <br>
 * <br>
 * Why? <br>
 * - To prevent changing behavior of important methods. <br>
 * <br>
 * ----------------------------- <br>
 * Key Points: <br>
 * <br>
 * 1. final method: <br>
 *    - Can be inherited <br>
 *    - Cannot be overridden <br>
 * <br>
 * 2. If subclass tries to override: <br>
 *    → Compile-time error <br>
 * <br>
 * 3. Used when: <br>
 *    - You want fixed logic <br>
 *    - Security / business rules should not change <br>
 *
 */

// Parent class
class Parent {

    final void show() {
        System.out.println("Final method in Parent");
    }
}

// Child class
class Child extends Parent {

    /*
     * NOT ALLOWED
     *
     * void show() {
     *     System.out.println("Overriding...");
     * }
     *
     * Compile-time error:
     * "Cannot override the final method from Parent"
     */

    void display() {
        System.out.println("Child method");
    }
}

public class FinalKeyword4 {

    public static void main(String[] args) {

        Child c = new Child();

        c.show();    // Inherited method
        c.display(); // Child method

    }
}