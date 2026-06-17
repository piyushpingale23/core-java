package com.core.java.design_pattern.singleton;

/*
 * =========================================================
 * SINGLETON DESIGN PATTERN
 * =========================================================
 *
 * What is Singleton?
 * -------------------
 * Singleton is a design pattern that ensures:
 * 1. Only one instance of a class is created
 * 2. That instance is globally accessible throughout the application
 *
 * ---------------------------------------------------------
 * Real-world Example:
 * ---------------------------------------------------------
 * Imagine a Database Connection Manager in an application.
 *
 * If multiple objects create multiple DB connections:
 * - Wastage of resources
 * - Performance issues
 *
 * Instead, we create only ONE shared connection manager:
 *
 * App Modules -----> Single DB Connection Object
 *
 * ---------------------------------------------------------
 * Key Idea:
 * ---------------------------------------------------------
 * - Constructor is PRIVATE → prevents external object creation
 * - Static instance -> holds single object
 * - getInstance() -> provides global access point
 *
 * ---------------------------------------------------------
 * When to use Singleton:
 * ---------------------------------------------------------
 * - Logger class
 * - DB connection pool
 * - Configuration manager
 * - Cache manager
 *
 * ---------------------------------------------------------
 * Important Behavior:
 * ---------------------------------------------------------
 * - First call -> object is created
 * - Next calls -> same object is returned
 * - Hence all references point to same memory location
 *
 * ---------------------------------------------------------
 * Result:
 * ---------------------------------------------------------
 * s1 == s2 -> true (same object reference)
 * =========================================================
 */

public class Singleton {

    private static Singleton instance;

    private Singleton() {

    }

    private static Singleton getInstance() {

        if (instance == null) {
            instance = new Singleton();
        }

        return instance;
    }

    public static void main(String[] args) {

        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        System.out.println(s1 == s2);
    }
}