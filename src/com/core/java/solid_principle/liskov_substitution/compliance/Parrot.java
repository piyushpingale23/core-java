package com.core.java.solid_principle.liskov_substitution.compliance;

public class Parrot extends FlyingBird {

    @Override
    public void eat() {
        System.out.println("Parrot can eat!");
    }

    @Override
    public void fly() {
        System.out.println("Parrot can fly!");
    }

}
