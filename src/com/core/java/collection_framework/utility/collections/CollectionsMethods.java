package com.core.java.collection_framework.utility.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
========================================================
Problem Statement:
Demonstrate commonly used Collections utility methods
and understand their behavior on List.

========================================================
Objective:
- Learn Collections class utility methods
- Understand sorting, searching, reversing, swapping etc.
- Practice real-world list operations
========================================================
*/

public class CollectionsMethods {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        list.add(40);
        list.add(10);
        list.add(30);
        list.add(20);
        list.add(50);

        System.out.println("Original List: " + list);

        /*
        ========================================================
        1. sort()
        ========================================================
        - Sorts list in natural order (ascending)
        */
        Collections.sort(list);
        System.out.println("After sort(): " + list);

        /*
        ========================================================
        2. reverse()
        ========================================================
        - Reverses current order of list
        */
        Collections.reverse(list);
        System.out.println("After reverse(): " + list);

        /*
        ========================================================
        3. shuffle()
        ========================================================
        - Randomly shuffles elements
        */
        Collections.shuffle(list);
        System.out.println("After shuffle(): " + list);

        /*
        ========================================================
        4. max()
        ========================================================
        - Returns maximum element
        */
        System.out.println("max(): " + Collections.max(list));

        /*
        ========================================================
        5. min()
        ========================================================
        - Returns minimum element
        */
        System.out.println("min(): " + Collections.min(list));

        /*
        ========================================================
        6. swap()
        ========================================================
        - Swaps elements at given indices
        */
        Collections.swap(list, 0, 1);
        System.out.println("After swap(0,1): " + list);

        /*
        ========================================================
        7. fill()
        ========================================================
        - Replaces all elements with same value
        */
        Collections.fill(list, 99);
        System.out.println("After fill(99): " + list);

        /*
        ========================================================
        8. frequency()
        ========================================================
        - Counts occurrences of an element
        */
        System.out.println("frequency(99): " + Collections.frequency(list, 99));

        /*
        ========================================================
        9. binarySearch()
        ========================================================
        - Searches element (list must be sorted first)
        - Returns index if found, else negative value
        */
        List<Integer> sortedList = new ArrayList<>();
        sortedList.add(10);
        sortedList.add(20);
        sortedList.add(30);
        sortedList.add(40);
        sortedList.add(50);

        int index = Collections.binarySearch(sortedList, 30);
        System.out.println("binarySearch(30): " + index);

        /*
        ========================================================
        10. unmodifiableList()
        ========================================================
        - Returns read-only list
        */
        List<Integer> unmodifiable = Collections.unmodifiableList(sortedList);
        System.out.println("Unmodifiable List: " + unmodifiable);

        /*
        ========================================================
        KEY POINTS
        ========================================================

        - Collections = utility class (static methods)
        - Works mainly with List
        - Some methods require sorted input (binarySearch)
        - Unmodifiable list throws UnsupportedOperationException on modification
        */
    }
}