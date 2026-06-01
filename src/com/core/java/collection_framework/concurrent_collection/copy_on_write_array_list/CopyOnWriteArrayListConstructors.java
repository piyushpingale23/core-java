package com.core.java.collection_framework.concurrent_collection.copy_on_write_array_list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListConstructors {

    public static void main(String[] args) {

        /*
         * Constructor 1: CopyOnWriteArrayList()
         * -------------------------------------
         * Creates an empty CopyOnWriteArrayList.
         */
        CopyOnWriteArrayList<String> list1 = new CopyOnWriteArrayList<>();

        list1.add("A");
        list1.add("B");

        System.out.println("list1 : " + list1);


        /*
         * Constructor 2: CopyOnWriteArrayList(Collection<? extends E> c)
         * --------------------------------------------------------------
         * Creates a CopyOnWriteArrayList containing all elements
         * from the specified collection.
         */
        List<String> arrayList = new ArrayList<>();

        arrayList.add("Java");
        arrayList.add("Spring");
        arrayList.add("Hibernate");

        CopyOnWriteArrayList<String> list2 = new CopyOnWriteArrayList<>(arrayList);

        System.out.println("list2 : " + list2);


        /*
         * Constructor 3: CopyOnWriteArrayList(E[] array)
         * ----------------------------------------------
         * Creates a CopyOnWriteArrayList containing the
         * elements of the specified array.
         */
        String[] technologies = {"Kafka", "Redis", "Docker"};

        CopyOnWriteArrayList<String> list3 = new CopyOnWriteArrayList<>(technologies);

        System.out.println("list3 : " + list3);


        /*
         * Another example using Arrays.asList()
         */
        CopyOnWriteArrayList<Integer> numbers = new CopyOnWriteArrayList<>(Arrays.asList(10, 20, 30, 40));

        System.out.println("numbers : " + numbers);
    }
}