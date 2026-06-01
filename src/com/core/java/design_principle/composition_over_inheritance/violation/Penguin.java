package com.core.java.design_principle.composition_over_inheritance.violation;

// VIOLATION: Penguin cannot fly, but is forced to implement fly()
// This breaks Liskov Substitution Principle (LSP)
// because Penguin cannot behave like a Bird in fly() context
class Penguin extends Bird {

    @Override
    public void fly() {
        System.out.println("Penguin cannot fly!");
        throw new UnsupportedOperationException("Penguins can't fly");
    }
}
