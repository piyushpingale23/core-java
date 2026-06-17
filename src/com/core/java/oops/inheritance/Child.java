package com.core.java.oops.inheritance;

public class Child extends Parent{

    int a = 30;
    int b = 40;
    int c = 50;

    Child() {
        System.out.println("Child Constructor!");
    }

    @Override
    public void m1() {
        System.out.println("Child m1()");
    }

    public void m2() {
        System.out.println("Child m2()");
    }

    public static void main(String[] args) {

        System.out.println("Parent Reference, Parent Object");
        Parent p1 = new Parent();
        p1.m1();
        // p1.m2() -> Parent do not have m2(), so it give compile-error
        p1.m3();
        System.out.println(p1.a);
        System.out.println(p1.b);
        //System.out.println(p1.c); -> Parent do not have 'c' variable, so it give compile-error
        System.out.println("------------------------------------");

        System.out.println("Parent Reference, Child Object");
        Parent p2 = new Child();
        p2.m1();
        // p2.m2() -> Parent do not have m2(), so it give compile-error
        p2.m3();
        System.out.println(p1.a);
        System.out.println(p1.b);
        //System.out.println(p1.c); -> Parent do not have 'c' variable, so it give compile-error
        System.out.println("------------------------------------");

        System.out.println("Chile Reference, Child Object");
        Child c = new Child();
        c.m1();
        c.m2();
        c.m3();
        System.out.println(c.a);
        System.out.println(c.b);
        System.out.println(c.c);
        System.out.println("------------------------------------");
    }
}
