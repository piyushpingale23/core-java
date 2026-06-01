package com.core.java.final_keyword;

/**
 * Concept: final static variable <br>
 * <br>
 * - A variable declared as 'static final' becomes a CONSTANT. <br>
 * <br>
 * Example: <br>
 * private static final String NAME = "Final"; <br>
 * <br>
 * ----------------------------- <br>
 * Meaning Breakdown: <br>
 * <br>
 * 1. static: <br>
 *    - Belongs to class, not object. <br>
 *    - Only ONE copy is created in memory (shared by all objects). <br>
 * <br>
 * 2. final: <br>
 *    - Value cannot be changed once assigned. <br>
 * <br>
 * ----------------------------- <br>
 * Combined Meaning (static + final): <br>
 * <br>
 * - Only ONE copy exists (static) <br>
 * - Value is FIXED (final) <br>
 * → So it behaves like a CONSTANT <br>
 * <br>
 * ----------------------------- <br>
 * Key Points: <br>
 * <br>
 * 1. Initialization: <br>
 *    - Must be initialized at declaration OR in static block <br>
 * <br>
 *    Example: <br>
 *    static final int X = 10; <br>
 * <br>
 *    OR <br>
 * <br>
 *    static final int X; <br>
 *    static { <br>
 *        X = 10; <br>
 *    } <br>
 * <br>
 * 2. Re-assignment: <br>
 *    - Not allowed <br>
 *    - Compile-time error if attempted <br>
 * <br>
 * 3. Memory: <br>
 *    - Stored in class area (method area) <br>
 *    - Shared across all objects <br>
 * <br>
 * 4. Naming Convention: <br>
 *    - CONSTANTS are written in UPPER_CASE (recommended) <br>
 * <br>
 * ----------------------------- <br>
 * Object Creation: <br>
 * <br>
 * FinalKeyword3 f1 = new FinalKeyword3(); <br>
 * FinalKeyword3 f2 = new FinalKeyword3(); <br>
 * <br>
 * - Objects are created, but NAME is NOT duplicated <br>
 * - Both objects share SAME variable <br>
 * <br>
 * ----------------------------- <br>
 * Access: <br>
 * <br>
 * System.out.println(NAME); <br>
 * <br>
 * Better practice: <br>
 * System.out.println(FinalKeyword3.NAME); <br>
 * <br>
 * (No need to create object for static variables) <br>
 * <br>
 * ----------------------------- <br>
 * Real-world Use: <br>
 * <br>
 * - Configuration values <br>
 * - Fixed constants (PI, MAX_SIZE, DB_URL, etc.) <br>
 *
 */
public class FinalKeyword3 {

    // one way to initialize the final variable at the declaration only
    private static final String NAME1 = "Final";

    /// another way to initialize the final variable through static block
    private static final String NAME2;
    static {
        NAME2 = "Variable";
    }

    public static void main(String[] args) {

        // Accessing constant
        System.out.println(NAME1); // Output: Final
        System.out.println(NAME2); // Output: Variable

        // Recommended way
        System.out.println(FinalKeyword3.NAME1);
        System.out.println(FinalKeyword3.NAME2);

        // NAME1 = "Changed"; // Compile-time error
    }
}