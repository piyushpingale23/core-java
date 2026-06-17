package com.core.java.java_8.lambda_expression;

// Functional Interface (single abstract method)
interface SquareIt {
    int squareIt(int n);
}

public class LambdaExpression2 {

    // Traditional Way: normal method
    public int square(int n) {
        return n * n;
    }

    public static void main(String[] args) {

        // -------------------------------
        // Traditional Way
        // -------------------------------
        LambdaExpression2 le2 = new LambdaExpression2();
        System.out.println("Square using Traditional Way: " + le2.square(4));

        // -------------------------------
        // Lambda Expression Way
        // -------------------------------
        SquareIt squareIt = n -> n * n;

        // Calling lambda implementation
        System.out.println("Square using Lambda Expression Way: " + squareIt.squareIt(5));
    }
}