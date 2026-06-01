package com.core.java.marker_interface.randomaccess.with;

import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;

class Student {

    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class StudentTest {

    public static void main(String[] args) {

        // STEP 1:
        // ArrayList internally creates a dynamic array (Object[])
        // Think of it like this in memory:

        // elementData (heap memory):
        // index →   0     1     2     3     4
        //         [null][null][null][null][null]

        List<Student> students = new ArrayList<>();

        // STEP 2:
        // When we add elements, they are stored in continuous array memory

        students.add(new Student(1, "A"));
        // elementData[0] → Student(1, "A")

        students.add(new Student(2, "B"));
        // elementData[1] → Student(2, "B")

        students.add(new Student(3, "C"));
        // elementData[2] → Student(3, "C")

        // INTERNAL MEMORY LOOK:
        // index →   0            1            2
        //         [A obj]     [B obj]     [C obj]

        // STEP 3:
        // RandomAccess check
        // ArrayList implements RandomAccess interface internally

        // So JVM sees:
        // ArrayList IS-A RandomAccess → TRUE

        System.out.println("Is RandomAccess? " + (students instanceof RandomAccess));

        System.out.println("----- Accessing elements -----");

        // STEP 4:
        // Now index-based loop starts

        for (int i = 0; i < students.size(); i++) {

            // STEP 5: MOST IMPORTANT PART (ArrayList.get(i))

            // ArrayList internally does:
            //
            // elementData[i]
            //
            // This means:
            // JVM does NOT traverse elements
            // JVM directly jumps to memory location

            /*
                MEMORY ACCESS VISUALIZATION:

                base address of array = 1000

                each reference size = 8 bytes (example)

                index 0 → 1000 + (0 * 8) = 1000
                index 1 → 1000 + (1 * 8) = 1008
                index 2 → 1000 + (2 * 8) = 1016

                So JVM directly calculates address
                and jumps to that memory location
            */

            Student s = students.get(i);

            // STEP 6:
            // No traversal, no loop inside get()
            // Direct pointer arithmetic + array indexing

            System.out.println(s.id + " " + s.name);
        }

        // FINAL SUMMARY:

        /*
            ArrayList (RandomAccess = YES)

            Access flow:
            get(i)
              ↓
            elementData[i]
              ↓
            direct memory jump

            Complexity:
            get(i) = O(1)
            loop = O(n)
            total = O(n)
        */
    }
}