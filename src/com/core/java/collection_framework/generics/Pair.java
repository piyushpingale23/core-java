package com.core.java.collection_framework.generics;

/*
========================================================
GENERIC CLASS WITH MULTIPLE TYPE PARAMETERS
========================================================

Concept: Pair<K, V>

This is called a "Multi-Type Parameter Generic Class".

--------------------------------------------------------
WHAT DOES IT MEAN?
--------------------------------------------------------

K → Key type (Generic type 1)
V → Value type (Generic type 2)

This allows us to store TWO different types together.

Example:
Pair<Integer, String>
→ K = Integer
→ V = String

Pair<String, Double>
→ K = String
→ V = Double

--------------------------------------------------------
WHY WE USE THIS?
--------------------------------------------------------

1. To represent key-value structure
2. To store related data together
3. Used internally in Map.Entry in Java
4. Improves type safety and avoids casting

--------------------------------------------------------
REAL WORLD USE CASES
--------------------------------------------------------

- HashMap entry representation
- Database key-value mapping
- API response wrappers
- Data transfer objects (DTOs)

--------------------------------------------------------
IMPORTANT POINTS
--------------------------------------------------------

- K and V are independent generic types
- Each object decides its own types at runtime (compile-time binding)
- Prevents mixing wrong types (type safety)

========================================================
*/

public class Pair<K, V> {

    private final K key;
    private final V value;

    Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public void show() {
        System.out.println("Key: " + key + ", Value: " + value);
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

/*
========================================================
TEST CLASS
========================================================
*/

class PairTest {
    public static void main(String[] args) {

        /*
         * Integer key and String value
         */
        Pair<Integer, String> p1 = new Pair<>(101, "PPI");

        /*
         * String key and Double value
         */
        Pair<String, Double> p2 = new Pair<>("PPI SCORE", 89.5);

        p1.show();
        p2.show();
    }
}