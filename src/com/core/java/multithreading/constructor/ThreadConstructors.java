package com.core.java.multithreading.constructor;

/*
 * Thread Constructors in Java
 *
 * The Thread class provides multiple constructors to create threads
 * in different ways. These constructors allow us to:
 * - Create a thread without any task
 * - Assign a task using Runnable
 * - Name the thread
 * - Set thread group (advanced concept)
 */

public class ThreadConstructors {

    public static void main(String[] args) {

        /*
         * 1. Thread()
         * Creates a thread without any Runnable task.
         * Default run() method of Thread class executes (which is empty).
         */
        Thread t1 = new Thread();
        t1.start(); // no output because run() is empty

        /*
         * 2. Thread(Runnable target)
         * Creates a thread and assigns a Runnable task to it.
         */
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable task executed by Thread");
            }
        };

        Thread t2 = new Thread(task);
        t2.start(); // executes Runnable run()

        /*
         * 3. Thread(String name)
         * Creates a thread with a name.
         */
        Thread t3 = new Thread("MyThread-1") {
            @Override
            public void run() {
                System.out.println("Thread name: " + Thread.currentThread().getName());
            }
        };

        t3.start();

        /*
         * 4. Thread(Runnable target, String name)
         * Creates a thread with Runnable task and a name.
         */
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable executed in named thread");
            }
        }, "Worker-Thread");

        t4.start();

        /*
         * 5. Thread(ThreadGroup group, Runnable target, String name)
         * Advanced constructor used for grouping threads (ThreadGroup concept).
         */
        ThreadGroup group = new ThreadGroup("MyGroup");

        Thread t5 = new Thread(group, new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread inside ThreadGroup: " + Thread.currentThread().getName());
            }
        }, "Grouped-Thread");

        t5.start();

        /*
         * Important Notes:
         * - start() creates a new thread
         * - run() contains the task logic
         * - Thread constructors help configure thread behavior before execution
         */

        System.out.println("Main Thread Finished");
    }
}