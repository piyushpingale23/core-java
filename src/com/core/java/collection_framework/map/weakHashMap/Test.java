package com.core.java.collection_framework.map.weakHashMap;

public class Test {

    @Override
    public String toString() {
        return "test";
    }

    @Override
    protected void finalize() {
        System.out.println("Finalize called!");
    }
}