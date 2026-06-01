package com.core.java.design_principle.composition_over_inheritance.compliance;

class Eagle extends Bird {

    // Eagle chooses correct behavior
    Eagle() {
        super(new NormalFly());
    }
}