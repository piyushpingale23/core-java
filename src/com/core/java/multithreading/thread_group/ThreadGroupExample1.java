package com.core.java.multithreading.thread_group;

public class ThreadGroupExample1 {

    public static void main(String[] args) {

        // Current thread is "main"
        // Main thread belongs to "main" ThreadGroup
        System.out.println(Thread.currentThread().getThreadGroup().getName());

        // No ThreadGroup is specified here
        // So t1 automatically inherits the ThreadGroup
        // of the thread that creates it (main thread)
        Thread t1 = new Thread(() -> {

            // t1 also belongs to "main" ThreadGroup
            System.out.println(Thread.currentThread().getThreadGroup().getName());
        });

        t1.start();
    }
}
