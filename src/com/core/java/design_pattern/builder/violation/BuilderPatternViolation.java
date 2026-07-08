package com.core.java.design_pattern.builder.violation;

import com.core.java.design_pattern.builder.Employee;

/*
 * VIOLATION: Telescoping Constructor Problem (Builder Pattern Violation)
 *
 * This design uses a constructor with many parameters,
 * which leads to multiple issues in maintainability and readability.
 *
 * Problems:
 *
 * 1. Poor Readability:
 *    - It is difficult to understand which value belongs to which field.
 *    - Example: "Piyush", "Ingale", "email", "phone", "Pune"
 *      -> You must remember parameter order.
 *
 * 2. Parameter Order Dependency:
 *    - If order is changed accidentally, wrong values will be assigned.
 *
 * 3. Hard to Maintain:
 *    - If a new field is added, constructor signature changes everywhere.
 *
 * 4. Too Many Null Values:
 *    - When only some fields are required, others are passed as null.
 *    - This leads to messy and unsafe object creation.
 *
 * 5. No Flexibility:
 *    - Cannot skip optional fields cleanly.
 *
 * 6. Constructor Explosion Problem:
 *    - As number of fields increases, multiple overloaded constructors
 *      would be needed (2 args, 3 args, 4 args...), making code complex.
 *
 * 7. Violates Open/Closed Principle:
 *    - Any new field addition forces modification in constructor usage everywhere.
 */

public class BuilderPatternViolation {

    public static void main(String[] args) {

        Employee employee = new Employee(
                "Piyush",
                "Ingale",
                "piyush@gmail.com",
                "9876543210",
                "Pune"
        );

        System.out.println(employee);

        // Problem example: optional fields handled using null
        Employee employee2 = new Employee(
                "Piyush",
                null,
                "piyush@gmail.com",
                null,
                null
        );
    }
}