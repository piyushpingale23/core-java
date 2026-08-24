package com.core.java.multithreading.synchronization.class_level;

public class ClassLevelLockExample {

    // "static synchronized" method uses the CLASS object as the lock.
    // Lock = ClassLevelLockExample.class
    // Since printNumbers() is static, there is no "this" object.
    // Therefore, the lock is acquired on the Class object itself.
    // Only ONE thread can execute this method at a time for this class.
    public static synchronized void printNumbers() {

        // The thread that successfully acquires the CLASS lock enters here
        System.out.println(Thread.currentThread().getName() + " entered printNumbers()");

        // This entire loop is protected by the class-level lock
        for (int i = 1; i <= 5; i++) {

            System.out.println(Thread.currentThread().getName() + " : " + i);

            try {

                // Thread goes into TIMED_WAITING for 1 second.
                // IMPORTANT:
                // Thread.sleep() does NOT release the class-level lock.
                Thread.sleep(1000);

            } catch (InterruptedException e) {

                // Restore the interrupted status of the thread
                Thread.currentThread().interrupt();

                // Exit the method and release the class-level lock
                return;
            }
        }

        // Method is about to finish.
        // After the method exits, the class-level lock is released.
        System.out.println(Thread.currentThread().getName() + " exited printNumbers()");
    }

    public static void main(String[] args) {

        // No object is required because printNumbers() is static.
        // Both threads call the SAME static synchronized method.
        // Therefore, both threads compete for the SAME CLASS lock.
        Thread t1 = new Thread(ClassLevelLockExample::printNumbers, "Thread-1");
        Thread t2 = new Thread(ClassLevelLockExample::printNumbers, "Thread-2");

        // Both threads start concurrently.
        // Whichever thread acquires ClassLevelLockExample.class lock first will enter printNumbers().
        // The other thread must wait until the first thread exits the synchronized method.
        t1.start();
        t2.start();
    }
}