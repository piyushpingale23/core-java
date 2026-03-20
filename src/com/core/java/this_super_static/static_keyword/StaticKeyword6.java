package com.core.java.this_super_static.static_keyword;

// Static and Non-Static Method Calling Another Static Method
public class StaticKeyword6 {

    public static void m1() {
        System.out.println("static m1()");
    }

    public void m2() {
        System.out.println("non static m2()");
    }

    public static void main(String[] args) {
        m1();
//        m2();  -> we cannot call non static m2() from static main()
//                  we need to call non static method from static method by using object

        StaticKeyword6 s6 = new StaticKeyword6();
        s6.m2();
    }
}
