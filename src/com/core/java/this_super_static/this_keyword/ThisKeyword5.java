package com.core.java.this_super_static.this_keyword;

// Purpose -> method call
public class ThisKeyword5 {

    private void m1 () {
        System.out.println("in m1()");
        this.m2();
    }

    private void m2 () {
        System.out.println("in m2()");
    }

    public static void main(String[] args) {
        ThisKeyword5 t = new ThisKeyword5();
        t.m1();
    }
}
