package com.core.java.design_principle.composition_over_inheritance.violation;

// OK here because Eagle can fly
class Eagle extends Bird {

    @Override
    public void fly() {
        System.out.println("Eagle can fly!");
    }
}
