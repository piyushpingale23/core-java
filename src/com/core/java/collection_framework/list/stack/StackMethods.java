package com.core.java.collection_framework.list.stack;

import java.util.Stack;

/*
========================================================
Problem Statement:
Demonstrate important Stack methods with examples.

Methods covered:
- push()
- pop()
- peek()
- empty()
- search()
- size()
- clear()

========================================================
Objective:
- Understand Stack (LIFO data structure)
- Learn push/pop operations
- Understand search behavior (1-based index from top)
========================================================
*/

public class StackMethods {

    public static void main(String[] args) {

        /*
        Stack:
        - Extends Vector class
        - LIFO (Last In First Out)
        - Legacy class
        - Synchronized
        */

        Stack<Integer> stack = new Stack<>();

        /*
        =========================
        push()
        =========================
        */
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        System.out.println("Stack after push: " + stack);

        /*
        =========================
        peek()
        =========================
        - Returns top element without removing it
        */
        System.out.println("peek(): " + stack.peek());

        /*
        =========================
        pop()
        =========================
        - Removes and returns top element
        */
        System.out.println("pop(): " + stack.pop());

        System.out.println("Stack after pop: " + stack);

        /*
        =========================
        search() - return the Offset
        =========================
        - Returns 1-based position from top
        - Returns -1 if not found
        */
        System.out.println("search(20): " + stack.search(20));

        /*
        =========================
        size()
        =========================
        */
        System.out.println("Size: " + stack.size());

        /*
        =========================
        empty()
        =========================
        */
        System.out.println("Is Empty? " + stack.empty());

        /*
        =========================
        clear()
        =========================
        */
        stack.clear();

        System.out.println("After clear: " + stack);
        System.out.println("Is Empty after clear? " + stack.empty());
    }
}