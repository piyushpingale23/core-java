package com.core.java.this_super_static.super_keyword;

// Purpose -> call Parent class constructor (super())
public class SuperKeyword2 {

    SuperKeyword2() {
        System.out.println("Parent constructor");
    }
}

class Test2 extends SuperKeyword2 {

    Test2() {
        super();
        System.out.println("Child constructor");
    }

    public static void main(String[] args) {

        Test2 t2 = new Test2();
    }

}