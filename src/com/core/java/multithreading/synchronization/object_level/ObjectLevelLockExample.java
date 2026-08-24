package com.core.java.multithreading.synchronization.object_level;

public class ObjectLevelLockExample {

    // "synchronized" instance method uses the current object (this) as the lock.
    //
    // Since both threads call printNumbers() on the SAME object "obj",
    // both threads compete for the SAME object-level lock.
    //
    // Only ONE thread can execute this method at a time for this object.
    public synchronized void printNumbers() {

        // The thread that successfully acquires the object lock enters here
        System.out.println(Thread.currentThread().getName() + " entered printNumbers()");

        // This entire loop is protected by the object-level lock
        for (int i = 1; i <= 5; i++) {

            System.out.println(Thread.currentThread().getName() + " : " + i);

            try {
                // Thread goes to TIMED_WAITING for 1 second.
                // IMPORTANT:
                // Thread.sleep() does NOT release the object lock.
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        // The thread reaches here while still holding the object lock.
        // After the method finishes, the lock is automatically released.
        System.out.println(Thread.currentThread().getName() + " exited printNumbers()");
    }

    public static void main(String[] args) {

        // Create ONE shared object.
        // The synchronized method locks this particular object.
        ObjectLevelLockExample obj = new ObjectLevelLockExample();

        // Both threads call printNumbers() on the SAME object "obj".
        // Therefore, both threads try to acquire the same object-level lock.
        Thread t1 = new Thread(obj::printNumbers, "Thread-1");
        Thread t2 = new Thread(obj::printNumbers, "Thread-2");

        // Thread-1 and Thread-2 start concurrently.
        // Whichever thread acquires object lock first will enter printNumbers().
        // The other thread must wait until the first thread exits the synchronized method.
        t1.start();
        t2.start();
    }
}