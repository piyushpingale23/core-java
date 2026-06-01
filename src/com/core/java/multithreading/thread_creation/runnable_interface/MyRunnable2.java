package com.core.java.multithreading.thread_creation.runnable_interface;

/**
 * Runnable Interface Execution Scenarios <br>
 * <br>
 * Important Concepts: <br>
 * - start() always creates a new thread (if Thread is properly constructed) <br>
 * - run() is always just a normal method call when called directly <br>
 * - Runnable only provides task logic, it cannot start a thread <br>
 */

public class MyRunnable2 implements Runnable {

    @Override
    public void run() {
        System.out.println("Child Thread!");
    }

    public static void main(String[] args) {

        MyRunnable2 myRunnable2 = new MyRunnable2();

        Thread t1 = new Thread();
        Thread t2 = new Thread(myRunnable2);

        // Case 1:
        // No Runnable passed to Thread
        // New thread created but Thread class run() is empty
        t1.start();

        // Case 2:
        // Normal method call, no new thread created
        t1.run();

        // Case 3:
        // New thread created, Runnable run() executed in child thread
        t2.start();

        // Case 4:
        // Normal method call, executes in main thread
        t2.run();

        // Case 5:
        // Compile-time error: Runnable has no start() method
        // myRunnable2.start();

        // Case 6:
        // Normal method call, executes in main thread
        myRunnable2.run();
    }
}