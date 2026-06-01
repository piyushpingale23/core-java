package com.core.java.collection_framework.generics;

/*
========================================================
GENERIC CLASS WITH BOUNDED TYPE PARAMETER
========================================================

Concept: T extends Number

This is called Bounded Type Parameter in Java Generics.

--------------------------------------------------------
WHAT DOES IT MEAN?
--------------------------------------------------------

T extends Number means:

T is restricted to only subclasses of Number class.

Allowed types:
- Integer
- Double
- Float
- Long
- Short
- Byte

Not allowed:
- String
- Object
- Character
- Any non-numeric custom class

--------------------------------------------------------
WHY WE USE "extends Number"?
--------------------------------------------------------

We use it because:
- We want to perform arithmetic operations
- Number class provides common methods like:
  - intValue()
  - doubleValue()
  - floatValue()

So we can safely convert any numeric type to double and perform operations.

--------------------------------------------------------
BENEFITS
--------------------------------------------------------

1. Compile-time type safety
2. No need for explicit casting
3. Reusable logic for all numeric types
4. Prevents invalid types like String

========================================================
*/

public class GenericClassBoundExample<T extends Number> {

    private final T a;
    private final T b;

    GenericClassBoundExample(T a, T b) {
        this.a = a;
        this.b = b;
    }

    private double A() {
        return a.doubleValue();
    }

    private double B() {
        return b.doubleValue();
    }

    public double add() {
        return A() + B();
    }

    public double subtract() {
        return A() - B();
    }

    public double multiply() {
        return A() * B();
    }

    public double divide() {
        if (B() == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return A() / B();
    }
}

class GenericClassBoundTest {

    public static void main(String[] args) {

        /*
         * Integer is allowed because it extends Number
         */
        GenericClassBoundExample<Integer> g1 = new GenericClassBoundExample<>(10, 5);

        System.out.println("Integer Operations:");
        System.out.println("Add: " + g1.add());
        System.out.println("Subtract: " + g1.subtract());
        System.out.println("Multiply: " + g1.multiply());
        System.out.println("Divide: " + g1.divide());
        System.out.println("--------------------------");

        /*
         * Double is allowed because it extends Number
         */
        GenericClassBoundExample<Double> g2 = new GenericClassBoundExample<>(12.5, 2.5);

        System.out.println("Double Operations:");
        System.out.println("Add: " + g2.add());
        System.out.println("Subtract: " + g2.subtract());
        System.out.println("Multiply: " + g2.multiply());
        System.out.println("Divide: " + g2.divide());

        /*
         * This is not allowed:
         * Generics1<String> g3 = new Generics1<>("10", "20");
         *
         * Reason: String does not extend Number
         */
    }
}