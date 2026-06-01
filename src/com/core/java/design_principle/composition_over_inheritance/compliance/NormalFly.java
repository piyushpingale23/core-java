package com.core.java.design_principle.composition_over_inheritance.compliance;

class NormalFly implements FlyBehavior {

    // Only classes that truly support flying use this
    public void fly() {
        System.out.println("Flying normally");
    }
}
