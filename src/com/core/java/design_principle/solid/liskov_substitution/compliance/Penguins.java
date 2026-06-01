package com.core.java.design_principle.solid.liskov_substitution.compliance;

public class Penguins extends Bird {

    @Override
    public void eat() {
        System.out.println("Penguins can eat!");
    }

    public void swim() {
        System.out.println("Penguins can swim!");
    }

}
