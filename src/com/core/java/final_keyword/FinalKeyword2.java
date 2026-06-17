package com.core.java.final_keyword;

/**
 * Concept: final instance variable <br>
 * <br>
 * - A final instance variable is a variable whose value cannot be changed <br>
 *   once it is assigned. <br>
 * <br>
 * Key Points: <br>
 * <br>
 * 1. Declaration: <br>
 *    final int i; <br>
 *    - 'i' is declared as final instance variable. <br>
 *    - It must be initialized exactly once. <br>
 * <br>
 * 2. Initialization Ways: <br>
 *    A final instance variable can be initialized: <br>
 * <br>
 *    a) At the time of declaration <br>
 *       final int i = 10; <br>
 * <br>
 *    b) Inside constructor (MOST COMMON) <br>
 *       this.i = value; <br>
 * <br>
 * 3. Important Rule: <br>
 *    - It MUST be initialized before constructor completes. <br>
 *    - If not initialized → compile-time error. <br>
 * <br>
 * 4. Re-assignment: <br>
 *    - Not allowed after initialization. <br>
 * <br>
 * ----------------------------- <br>
 * IMPORTANT MISTAKE IN CODE: <br>
 * <br>
 * FinalKeyword2 (int i) { <br>
 *     i = 20;        // This modifies local parameter 'i' <br>
 *     this.i = i;    // Assigns 20 to instance variable <br>
 * } <br>
 * <br>
 * Explanation: <br>
 * - 'i' inside constructor is a LOCAL variable (parameter) <br>
 * - 'this.i' refers to INSTANCE variable <br>
 * <br>
 * So: <br>
 * i = 20; → changes parameter <br>
 * this.i = i; → assigns 20 to instance variable <br>
 * <br>
 * Input (10) is ignored <br>
 *
 * ----------------------------- <br>
 * CORRECT APPROACH: <br>
 * <br>
 * this.i = i; <br>
 * <br>
 * ----------------------------- <br>
 * Final Behavior: <br>
 * <br>
 * new FinalKeyword2(10); <br>
 * <br>
 * Output: <br>
 * 10
 *
 */
public class FinalKeyword2 {

    final int i;

    FinalKeyword2(int i) {
        // Wrong way (explained above)
        // i = 20;

        // Correct initialization
        // this.i = 20;
        this.i = i;
    }

    public static void main(String[] args) {

        FinalKeyword2 f2 = new FinalKeyword2(10);
        System.out.println(f2.i); // Output: 10

    }
}