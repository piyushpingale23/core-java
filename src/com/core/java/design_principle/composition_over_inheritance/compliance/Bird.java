package com.core.java.design_principle.composition_over_inheritance.compliance;

class Bird {

    // Composition:
    // Bird does NOT define flying behavior itself.
    // Instead, it "HAS-A" FlyBehavior object (delegation).

    // This is a reference variable (not object creation yet)
    private FlyBehavior flyBehavior;

    // Constructor Injection (Dependency Injection style)
    // Bird does NOT create FlyBehavior itself.
    // It receives an already created object from outside.

    // Important:
    // FlyBehavior is an interface (type only), not a class.
    // So ANY object that implements FlyBehavior can be passed here.
    Bird(FlyBehavior flyBehavior) {

        // At this point:
        // flyBehavior parameter holds reference to actual object
        // (e.g., new NormalFly(), new NoFly(), etc.)

        this.flyBehavior = flyBehavior;
    }

    void performFly() {

        // Delegation:
        // Bird is NOT implementing flying logic itself.

        // Instead, it forwards the call to the actual object
        // that was injected via constructor.

        // Runtime behavior decision happens HERE:
        // whichever object was passed (NormalFly / NoFly / RocketFly)
        // its fly() method will execute.

        flyBehavior.fly();
    }
}
