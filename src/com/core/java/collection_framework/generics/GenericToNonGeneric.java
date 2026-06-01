package com.core.java.collection_framework.generics;

import java.util.ArrayList;
import java.util.List;

/*
========================================================
GENERIC TO NON-GENERIC CONVERSION
========================================================

Concept:
A Generic collection becomes NON-GENERIC when passed
to a raw type method.

--------------------------------------------------------
WHAT IS RAW TYPE?
--------------------------------------------------------

Raw type means using collection without generic type.

Example:
ArrayList list = new ArrayList();

Here:
- No type safety exists
- Any type of object can be added

--------------------------------------------------------
IMPORTANT CONCEPT
--------------------------------------------------------

List<String> list = new ArrayList<>();

This list should normally allow ONLY String objects.

But when passed to:

m1(ArrayList list)

the generic information is lost because:
- Raw type disables generic type checking
- Compiler treats it like non-generic collection

So inside m1():
- Integer
- Double
- Boolean
- String

all can be added successfully.

--------------------------------------------------------
WHY THIS IS DANGEROUS?
--------------------------------------------------------

Because later while retrieving elements:

for (String s : list)

Java expects only String objects.

But Integer/Double/Boolean also exist inside list.

This causes:
ClassCastException at runtime.

--------------------------------------------------------
KEY POINT
--------------------------------------------------------

Generics provide compile-time safety only.

At runtime:
- Generic type information is removed
- This process is called Type Erasure

========================================================
*/

public class GenericToNonGeneric {

    public static void main(String[] args) {

        /*
         * Generic List
         * Only String objects should be allowed
         */
        List<String> list = new ArrayList<>();

        list.add("A");
        list.add("B");

        // list.add(12); // Compile-time error

        /*
         * Passing generic collection to raw type method
         */
        m1((ArrayList) list);

        list.add("D");

        /*
         * Internally list now contains:
         * A, B, 10, 11.5, C, true, D
         */

        System.out.println(list);

        /*
         * Runtime problem example
         */
        for (String s : list) {

            /*
             * Integer/Double/Boolean cannot
             * be converted to String
             */

            System.out.println(s);
        }
    }

    /*
     * Raw type method
     * Generic safety removed here
     */
    public static void m1(ArrayList list) {

        list.add(10);
        list.add(11.5);
        list.add("C");
        list.add(true);
    }
}