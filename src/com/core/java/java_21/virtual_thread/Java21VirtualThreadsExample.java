package com.core.java.java_21.virtual_thread;

public class Java21VirtualThreadsExample {

    public static void main(String[] args) throws InterruptedException {

        // Main thread
        System.out.println("Main thread is virtual: " + Thread.currentThread().isVirtual());

        // Create and start a virtual thread
        Thread virtualThread = Thread.ofVirtual().start(() -> {
            System.out.println("Virtual thread is virtual: " + Thread.currentThread().isVirtual());
            System.out.println("Executing a task...");
        });

        // Wait for the virtual thread to finish
        virtualThread.join();

        System.out.println("Main thread completed.");
    }
}
