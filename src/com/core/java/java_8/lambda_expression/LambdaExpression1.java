package com.core.java.java_8.lambda_expression;

// Functional Interface (target type for lambda)
// Contains only one abstract method
@FunctionalInterface
interface Addable {
    void add(int a, int b);
}

public class LambdaExpression1 {

    // Traditional Way: normal method inside class
    public void add(int a, int b) {
        System.out.println("Addition (Traditional Way) : " + (a + b));
    }

    public static void main(String[] args) {

        // -------------------------------
        // Traditional Way (object + method call)
        // -------------------------------
        LambdaExpression1 le = new LambdaExpression1();
        le.add(10, 20);

        // -------------------------------
        // Lambda Expression Way
        // Implements Addable interface method in a short form
        // -------------------------------
        Addable obj = (a, b) -> System.out.println("Addition (Lambda Expression Way) : " + (a + b));

        // Calling lambda implementation
        obj.add(10, 20);
    }
}