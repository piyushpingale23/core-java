package com.core.java.design_principle.composition_over_inheritance.compliance;

class Penguin extends Bird {

    // Penguin does NOT inherit wrong behavior
    // Instead gets "NoFly" behavior safely
    Penguin() {
        super(new NoFly());
    }
}
