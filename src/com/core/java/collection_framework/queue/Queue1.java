package com.core.java.collection_framework.queue;

import java.util.LinkedList;
import java.util.Queue;

/*
========================================================
Problem Statement:
Demonstrate Queue methods using Queue interface with
LinkedList implementation and explain PriorityQueue-style
queue operations.

Methods covered:
- offer()
- peek()
- element()
- poll()
- remove()

========================================================
Objective:
- Understand Queue operations (FIFO)
- Learn difference between similar methods
- Understand exception vs safe-return behavior
========================================================
*/

public class Queue1 {

    public static void main(String[] args) {

        /*
        Queue:
        - FIFO (First In First Out)
        - Interface in Java
        - Common implementation: LinkedList, PriorityQueue
        */

        Queue<Integer> queue = new LinkedList<>();

        /*
        =========================
        offer()
        =========================
        - Inserts element into queue
        - Returns true/false (safe insert)
        */
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);

        System.out.println("Queue after offer(): " + queue);

        /*
        =========================
        peek()
        =========================
        - Returns head element WITHOUT removing it
        - Returns null if queue is empty
        */
        System.out.println("peek(): " + queue.peek());

        /*
        =========================
        element()
        =========================
        - Same as peek()
        - BUT throws exception if queue is empty (NoSuchElementException)
        */
        System.out.println("element(): " + queue.element());

        /*
        =========================
        poll()
        =========================
        - Removes and returns head element
        - Returns null if queue is empty
        */
        System.out.println("poll(): " + queue.poll());

        System.out.println("Queue after poll(): " + queue);

        /*
        =========================
        remove()
        =========================
        - Removes and returns head element
        - Throws exception if queue is empty
        */
        System.out.println("remove(): " + queue.remove());

        System.out.println("Queue after remove(): " + queue);

        /*
        ========================================================
        KEY DIFFERENCE SUMMARY
        ========================================================

        offer()  -> insert safely (returns boolean)
        add()    -> insert (throws exception if fails)

        peek()   -> view head (returns null if empty)
        element()-> view head (throws exception if empty)

        poll()   -> remove head (returns null if empty)
        remove() -> remove head (throws exception if empty)
        */
    }
}