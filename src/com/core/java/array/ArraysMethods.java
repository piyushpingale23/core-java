package com.core.java.array;

import java.util.Arrays;
import java.util.List;

public class ArraysMethods {

    public static void main(String[] args) {

        // Original array
        int[] arr = {5, 2, 8, 1, 3};

        // 1. sort()
        int[] sorted = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sorted);
        System.out.println("sort(): " + Arrays.toString(sorted));

        // 2. parallelSort()
        int[] parallelSorted = Arrays.copyOf(arr, arr.length);
        Arrays.parallelSort(parallelSorted);
        System.out.println("parallelSort(): " + Arrays.toString(parallelSorted));

        // 3. binarySearch()
        int index = Arrays.binarySearch(parallelSorted, 3);
        System.out.println("binarySearch(3): " + index);

        // 4. equals()
        int[] arr2 = {1, 2, 3, 5, 8};
        System.out.println("equals(): " + Arrays.equals(parallelSorted, arr2));

        // 5. compare()
        int[] compareArray = {1, 2, 4};
        System.out.println("compare(): " + Arrays.compare(arr2, compareArray));

        // 6. mismatch()
        System.out.println("mismatch(): " + Arrays.mismatch(arr2, compareArray));

        // 7. fill()
        int[] filled = new int[5];
        Arrays.fill(filled, 10);
        System.out.println("fill(): " + Arrays.toString(filled));

        // 8. fill() with range
        Arrays.fill(filled, 1, 4, 99);
        System.out.println("fill(range): " + Arrays.toString(filled));

        // 9. copyOf()
        int[] copy = Arrays.copyOf(arr, 7);
        System.out.println("copyOf(): " + Arrays.toString(copy));

        // 10. copyOfRange()
        int[] range = Arrays.copyOfRange(arr, 1, 4);
        System.out.println("copyOfRange(): " + Arrays.toString(range));

        // 11. toString()
        System.out.println("toString(): " + Arrays.toString(arr));

        // 12. deepToString()
        int[][] matrix = {{1, 2}, {3, 4}};
        System.out.println("deepToString(): " + Arrays.deepToString(matrix));

        // 13. deepEquals()
        int[][] matrix2 = {{1, 2}, {3, 4}};
        System.out.println("deepEquals(): " + Arrays.deepEquals(matrix, matrix2));

        // 14. hashCode()
        System.out.println("hashCode(): " + Arrays.hashCode(arr));

        // 15. deepHashCode()
        System.out.println("deepHashCode(): " + Arrays.deepHashCode(matrix));

        // 16. stream()
        System.out.print("stream(): ");
        Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
        System.out.println();

        // 17. setAll()
        int[] setAllArray = new int[5];
        Arrays.setAll(setAllArray, i -> i + 1);
        System.out.println("setAll(): " + Arrays.toString(setAllArray));

        // 18. parallelSetAll()
        int[] parallelSet = new int[5];
        Arrays.parallelSetAll(parallelSet, i -> i * 10);
        System.out.println("parallelSetAll(): " + Arrays.toString(parallelSet));

        // 19. parallelPrefix()
        int[] prefix = {1, 2, 3, 4};
        Arrays.parallelPrefix(prefix, Integer::sum);
        System.out.println("parallelPrefix(): " + Arrays.toString(prefix));

        // 20. asList()
        List<String> list = Arrays.asList("Java", "Spring", "Boot");
        System.out.println("asList(): " + list);
    }
}
