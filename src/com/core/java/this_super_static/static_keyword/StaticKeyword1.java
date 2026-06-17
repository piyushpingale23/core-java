package com.core.java.this_super_static.static_keyword;

// Static Variable (Shared Data)
class StaticKeyword1 {

    static int count = 0;
    public static final String s = "StaticKeyword1";

    StaticKeyword1() {
        count++;
    }

    void show() {
        System.out.println(count);
    }

    public static void main(String[] args) {

        StaticKeyword1 s1 = new StaticKeyword1();
        StaticKeyword1 s2 = new StaticKeyword1();

        System.out.println(s);
        System.out.println(s1.s);
        System.out.println(s2.s);
        System.out.println(StaticKeyword1.s);

        s1.show();
        s2.show();

    }
}

//Concept :
//count is a static variable
//Belongs to the class, not objects
//Only one copy is created in memory
//
//Flow :
//Class loads -> count = 0
//s1 object created -> constructor runs -> count = 1
//s2 object created -> constructor runs -> count = 2
