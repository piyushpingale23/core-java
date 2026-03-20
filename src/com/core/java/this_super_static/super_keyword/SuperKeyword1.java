package com.core.java.this_super_static.super_keyword;

// Purpose -> Variable and method calling (super keyword)
public class SuperKeyword1 {

    int a = 10;

    void m1 () {
        System.out.println("Parent -> m1()");
    }
}

class Test1 extends SuperKeyword1 {

    int b = 20;

    void m1 () {
        super.m1();
        System.out.println("Child -> m1()");
    }

    void m2 () {
        this.m1();
        System.out.println("Child -> m2()");
    }

    void m3() {
        System.out.println("Parent a -> " + super.a);
        System.out.println("Child b -> " + this.b);
        m2();
    }

    public static void main(String[] args) {

        Test1 t1 = new Test1();
        t1.m3();

    }
}
