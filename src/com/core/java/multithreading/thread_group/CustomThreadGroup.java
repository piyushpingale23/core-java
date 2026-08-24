package com.core.java.multithreading.thread_group;

public class CustomThreadGroup {

    public static void main(String[] args) {

        // Create a custom ThreadGroup named "CUSTOM-GROUP"
        ThreadGroup customGroup = new ThreadGroup("custom-group");

        // Create a thread and explicitly assign it to custom-group
        // If we don't pass customGroup, the thread would belong to the "main" ThreadGroup
        Thread t1 = new Thread(customGroup, () -> {

            // Print the current thread name
            System.out.println("Thread Name  : " + Thread.currentThread().getName());

            // Print the ThreadGroup of the current thread
            // Output: custom-group
            System.out.println("Thread Group : " + Thread.currentThread().getThreadGroup().getName());

        }, "Worker-1");

        // Start the thread
        t1.start();

        // Main thread still belongs to the default "main" ThreadGroup
        // Creating a custom ThreadGroup does not change the main thread's group
        System.out.println("Main Thread Group : " + Thread.currentThread().getThreadGroup().getName());
    }
}