package com.core.java.oops.encapsulation.otherpackage;

import com.core.java.oops.encapsulation.accessmodifiers.A;

public class C {

    public static void main(String[] args) {

        A obj = new A();

        System.out.println(obj.publicVar);     // only public works

        // System.out.println(obj.protectedVar); // not allowed
        // System.out.println(obj.defaultVar);   // not allowed
        // System.out.println(obj.privateVar);   // not allowed
    }
}
