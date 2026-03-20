package com.core.java.solid_principle.liskov_substitution.violation;

public class Penguins extends Bird{

    @Override
    public void eat() {
        System.out.println("Penguins can eat!");
    }

    @Override
    public void fly() {
        System.out.println("Penguins can not fly!");
    }

    /*
     * Problem:
     * The parent class Bird defines a fly() method, assuming all birds can fly.
     * However, Penguins cannot fly.
     *
     * Even though we override fly(), the behavior is not valid for Penguins.
     * This breaks the expected behavior of the parent class.
     *
     * Liskov Substitution Principle (LSP) Violation:
     * A subclass should be able to replace its parent class without changing expected behavior.
     * Here, if we use Penguins in place of Bird, the fly() method behaves incorrectly.
     *
     * Conclusion:
     * The design is wrong because not all birds can fly.
     * We should redesign the class hierarchy (e.g., separate FlyingBird).
     */

}
