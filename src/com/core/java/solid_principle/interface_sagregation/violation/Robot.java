package com.core.java.solid_principle.interface_sagregation.violation;

public class Robot implements Worker {

    @Override
    public void work() {
        System.out.println("Robot working");
    }

    @Override
    public void eat() {
        // Robot does not eat, but is forced to implement this method
        // because Worker interface contains eat()
        // This is a violation of the Interface Segregation Principle (ISP)
        // ISP states: clients should not be forced to depend on methods they do not use
    }

}