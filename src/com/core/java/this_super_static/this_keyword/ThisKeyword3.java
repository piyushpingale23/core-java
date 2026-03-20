package com.core.java.this_super_static.this_keyword;

// Purpose -> to pass current object as method parameter
public class ThisKeyword3 {

    private void m1 (ThisKeyword3 t) {
        System.out.println("in m1()");
        t.m3();
    }

    private void m2() {
        System.out.println("in m2()");
        m1(this);
    }

    private void m3() {
        System.out.println("in m3()");
    }

    public static void main(String[] args) {
        ThisKeyword3 t = new ThisKeyword3();
        t.m2();
    }
}
