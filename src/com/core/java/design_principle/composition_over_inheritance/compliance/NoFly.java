package com.core.java.design_principle.composition_over_inheritance.compliance;

class NoFly implements FlyBehavior {

    // Explicitly represents non-flying behavior
    // No exception needed -> safe design
    public void fly() {
        System.out.println("Cannot fly");
    }
}
