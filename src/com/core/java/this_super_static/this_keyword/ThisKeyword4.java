package com.core.java.this_super_static.this_keyword;

// Purpose -> return current object
public class ThisKeyword4 {

    private ThisKeyword4 currentObject () {
        return (this);
    }

    public static void main(String[] args) {

        ThisKeyword4 t1 = new ThisKeyword4();
        ThisKeyword4 t2 = t1.currentObject();

        System.out.println("t1 -> " + t1);
        System.out.println("t2 -> " + t2);

    }
}
