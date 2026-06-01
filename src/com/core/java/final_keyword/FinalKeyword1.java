package com.core.java.final_keyword;

/**
 * Concept: final keyword with variables <br>
 * <br>
 * - The 'final' keyword is used to make a variable constant. <br>
 * - Once a final variable is assigned a value, it cannot be reassigned. <br>
 * <br>
 * Key Points:
 *  <br>
 * 1. Initialization: <br>
 *    - A final variable must be initialized only once. <br>
 *    - It can be initialized: <br>
 *         a) At the time of declaration <br>
 *         b) Inside constructor (for instance variables) <br>
 * <br>
 * 2. Re-assignment: <br>
 *    - Re-assignment is NOT allowed. <br>
 *    - If we try to assign a new value, it gives compile-time error. <br>
 * <br>
 * 3. Memory Behavior: <br>
 *    - Value of final variable is fixed after initialization. <br>
 *    - It behaves like a constant. <br>
 * <br>
 * 4. Naming Convention: <br>
 *    - Generally written in UPPER_CASE (not mandatory). <br>
 * <br>
 * Example Explanation: <br>
 * <br>
 * final int i = 10; <br>
 * <br>
 * - 'i' is declared as final. <br>
 * - Value 10 is assigned at the time of declaration. <br>
 * <br>
 * If we try: <br>
 * i = 20; <br>
 * <br>
 * - Compiler will give error: <br>
 *   "cannot assign a value to final variable i" <br>
 * <br>
 * Reason: <br>
 * - Because final variable can be assigned only once.
 *
 */
public class FinalKeyword1 {

    public static void main(String[] args) {

        final int i = 10;

        // i = 20;  // Compile-time error

        System.out.println(i);
    }
}