package com.core.java.design_principle.solid.liskov_substitution.violation;

public class Parrot extends Bird{

    @Override
    public void eat() {
        System.out.println("Parrot can eat!");
    }

    @Override
    public void fly() {
        System.out.println("Parrot can fly!");
    }

    /*
     * Explanation:
     * Parrot can both eat and fly, which matches the behavior defined in the parent class (Bird).
     *
     * Liskov Substitution Principle (LSP):
     * A subclass should be able to replace the parent class without breaking expected behavior.
     *
     * In this case, Parrot fully supports all behaviors of Bird.
     * So, Parrot can safely be used wherever a Bird is expected.
     *
     * Conclusion:
     * This is a correct implementation and does NOT violate LSP.
     */
}
