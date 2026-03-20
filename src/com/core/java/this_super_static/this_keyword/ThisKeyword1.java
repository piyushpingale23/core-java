package com.core.java.this_super_static.this_keyword;

// Purpose -> differentiate instance variable
public class ThisKeyword1 {

    int i;

    ThisKeyword1(int i) {
        this.i = i;
    }

    public static void main(String[] args) {
        ThisKeyword1 thisKeyword1 = new ThisKeyword1(10);
        System.out.println(thisKeyword1.i);
    }
}
