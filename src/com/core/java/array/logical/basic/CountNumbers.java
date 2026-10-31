package com.core.java.array.logical.basic;

// Count positive, negative and zero elements
public class CountNumbers {

    public static void main(String[] args) {

        int[] array = {-1, 0, 2, -4};

        int positive = 0;
        int negative = 0;
        int zero = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                positive ++;
            } else if (array[i] < 0) {
                negative ++;
            } else zero ++;
        }

        System.out.println("Zero count    : " + zero);
        System.out.println("Positive count: " + positive);
        System.out.println("Negative count: " + negative);
    }

}
