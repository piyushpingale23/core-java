package com.core.java.oops.encapsulation.accessmodifiers;

public class B {

    public static void main(String[] args) {

        A obj = new A();

        System.out.println(obj.publicVar);     // allowed
        // System.out.println(obj.privateVar);  // not allowed
        System.out.println(obj.protectedVar);   // allowed (same package)
        System.out.println(obj.defaultVar);     // allowed
    }
}
