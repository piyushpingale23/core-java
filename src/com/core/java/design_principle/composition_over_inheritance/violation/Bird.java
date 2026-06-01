package com.core.java.design_principle.composition_over_inheritance.violation;

// Base class assumes ALL birds can fly
abstract class Bird {

    // Violation: Not all subclasses can support this behavior
    // This forces every Bird child to inherit "fly", even if it doesn't make sense
    public abstract void fly();

}
