package com.core.java.collection_framework.logical;

import java.util.*;

/*
Find Intersection of Two Lists
Input: [1,2,3,4], [3,4,5,6]
Output: [3,4]
*/
public class CollectionFramework8 {

    public static void main(String[] args) {

        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> list2 = Arrays.asList(3, 4, 5, 6);

        Set<Integer> set = new HashSet<>(list1);

        List<Integer> result = new ArrayList<>();

        for (Integer number : list2) {
            if (set.contains(number)) {
                result.add(number);
            }
        }

        System.out.println(result);

    }
}