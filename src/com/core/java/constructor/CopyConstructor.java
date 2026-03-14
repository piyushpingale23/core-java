package com.core.java.constructor;

public class CopyConstructor {

    int id;
    String name;

    // Parameterized constructor
    CopyConstructor(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Copy constructor
    CopyConstructor(CopyConstructor cc) {
        this.id = cc.id;
        this.name = cc.name;
    }

    public void display() {
        System.out.println("Id: " + id);
        System.out.println("Name: " + name);
    }

    public static void main(String[] args) {
        CopyConstructor cc1 = new CopyConstructor(10, "jack");
        CopyConstructor cc2 = new CopyConstructor(cc1);

        cc1.display();
        cc2.display();
    }
}