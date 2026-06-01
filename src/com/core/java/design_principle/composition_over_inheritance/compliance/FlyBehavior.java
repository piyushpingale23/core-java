package com.core.java.design_principle.composition_over_inheritance.compliance;

// Behavior is separated from Bird class
interface FlyBehavior {

    // Only defines capability, not forced inheritance
    void fly();
}
