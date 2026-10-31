package com.core.java.array.logical.basic;

public class CountEvenAndOddNumbers {

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int evenCount = 0;
        int oddCount = 0;

        for (int i = 0; i < array.length; i++) {

            if (array[i] % 2 == 0) {
                evenCount ++;
            } else oddCount++;
        }

        System.out.println("even count: " + evenCount);
        System.out.println("odd count : " + oddCount);

    }
}
