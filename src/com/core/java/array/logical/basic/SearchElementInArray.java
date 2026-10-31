package com.core.java.array.logical.basic;

import java.util.Scanner;

public class SearchElementInArray {

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5, 6, 7};

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter target element: ");
        int target = sc.nextInt();

        int targetIndex = -1;

        for (int i = 0; i < array.length; i ++) {
            if (target == array[i]) {
                targetIndex = i;
                break;
            }
        }

        if (targetIndex == -1) {
            System.out.println(target + " is not present in array");
        } else System.out.println(target + " is present at " + targetIndex + " index in array");
    }
}
