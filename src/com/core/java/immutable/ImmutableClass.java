package com.core.java.immutable;

public class ImmutableClass {

    private final int i;

    ImmutableClass (int i) {
        this.i = i;
    }

    public ImmutableClass modify(int i) {
        if (this.i == i) {
            return this;
        }
        return new ImmutableClass(i);
    }

    public static void main(String[] args) {

        ImmutableClass im1 = new ImmutableClass(10);
        ImmutableClass im2 = im1.modify(10);
        ImmutableClass im3 = im1.modify(20);

        System.out.println(im1 == im2);
        System.out.println(im1 == im3);
    }
}
