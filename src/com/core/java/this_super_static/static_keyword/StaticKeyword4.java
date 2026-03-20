package com.core.java.this_super_static.static_keyword;

// static vs non-static access
public class StaticKeyword4 {

    static int x = 10;
    int y = 20;

    static void m1() {
        System.out.println(x);   // allowed
//         System.out.println(y); // not allowed
    }

    void m2() {
        System.out.println(x); // allowed
        System.out.println(y); // allowed
    }
}
