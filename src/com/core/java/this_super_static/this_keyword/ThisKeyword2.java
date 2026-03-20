package com.core.java.this_super_static.this_keyword;

// Purpose -> to call another constructor
public class ThisKeyword2 {

    int i;
    String s;

    ThisKeyword2 () {
        System.out.println("default");
    }

    ThisKeyword2 (int i) {
        this();
        this.i = i;
        System.out.println("int constructor");
    }

    ThisKeyword2 (String s) {
        this(10);
        this.s = s;
        System.out.println("String constructor");
    }

    public static void main(String[] args) {

        ThisKeyword2 thisKeyword2 = new ThisKeyword2("Jack");

        System.out.println(thisKeyword2.i);
        System.out.println(thisKeyword2.s);

    }


}
