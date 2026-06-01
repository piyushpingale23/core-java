package com.core.java.marker_interface.randomaccess.without;

import java.util.LinkedList;
import java.util.List;
import java.util.RandomAccess;

class Employee {

    int id;
    String name;

    Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class EmployeeTest {

    public static void main(String[] args) {

        // STEP 1:
        // LinkedList is created (NOT a contiguous array)
        //
        // Internal structure is NODE-based:
        //
        // head → [A | next] → [B | next] → [C | null]

        List<Employee> employees = new LinkedList<>();

        // STEP 2:
        // Adding elements creates separate nodes in heap

        employees.add(new Employee(1, "A"));
        // Node1: [A] → next

        employees.add(new Employee(2, "B"));
        // Node2: [B] → next

        employees.add(new Employee(3, "C"));
        // Node3: [C] → null

        // INTERNAL MEMORY LOOK (Linked structure):

        /*
            head
             ↓
            [A | next] → [B | next] → [C | null]
        */

        // STEP 3:
        // RandomAccess check
        // LinkedList does NOT implement RandomAccess

        System.out.println("Is RandomAccess? " + (employees instanceof RandomAccess));

        System.out.println("----- Accessing elements -----");

        // STEP 4:
        // Index-based loop starts

        for (int i = 0; i < employees.size(); i++) {

            // STEP 5: IMPORTANT INTERNAL WORKING OF get(i)

            // LinkedList.get(i) does NOT do direct access
            //
            // Instead it does:
            //
            // 1. Start from HEAD node
            // 2. Traverse node-by-node until index i

            /*
                ACCESS VISUALIZATION:

                get(0):
                    head → A (1 step)

                get(1):
                    head → A → B (2 steps)

                get(2):
                    head → A → B → C (3 steps)
            */

            Employee e = employees.get(i);

            // STEP 6:
            // Every get(i) = traversal operation
            // NOT direct memory jump

            System.out.println(e.id + " " + e.name);
        }

        // FINAL COMPLEXITY ANALYSIS:

        /*
            LinkedList (NO RandomAccess)

            Access flow:
            get(i)
              ↓
            traverse nodes from head
              ↓
            reach index i

            Complexity:
            get(i) = O(n)

            Loop:
            n times get(i)

            Total:
            O(n²)
        */
    }
}
