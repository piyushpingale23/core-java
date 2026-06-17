package com.core.java.oops.encapsulation.accessmodifiers;

public class A {

    public int publicVar = 10;
    private int privateVar = 20;
    protected int protectedVar = 30;
    int defaultVar = 40; // default (package-private)

    public void showInsideClass() {
        System.out.println(privateVar); // allowed (same class)
    }

    public int getPrivateVar() {
        return privateVar;
    }
}
