package com.core.java.array.logical.basic;

import java.util.Arrays;

public class MoveZerosToEnd {

    public static void main(String[] args) {

        int[] array = {1, 0, 0, 2, 0, 5};

        System.out.println("Original array: " + Arrays.toString(array));

        for (int i = 0; i < array.length; i++) {

            for (int j = i; j < array.length - 1; j++) {

                if (array[j] == 0) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }

            }

        }

//        int left = 0;
//        int right = array.length - 1;
//        while (left < right) {
//            if (array[left] == 0 && array[right] != 0) {
//                int temp = array[left];
//                array[left] = array[right];
//                array[right] = temp;
//            }
//
//            left ++;
//            right --;
//        }



        System.out.println("Array after moving zeros: " + Arrays.toString(array));
    }
}
