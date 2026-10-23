package com.core.java.collection_framework.logical;

import java.util.*;

/*
Merge Two Lists Without Duplicates
List1 = [1,2,3,4]
List2 = [3,4,5,6]
Output: [1,2,3,4,5,6]
* */
public class CollectionFramework6 {

    public static void main(String[] args) {

        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> list2 = Arrays.asList(3, 4, 5, 6);

        Set<Integer> result = new HashSet<>();

        result.addAll(list1);
        result.addAll(list2);

        System.out.println(result);

    }
}