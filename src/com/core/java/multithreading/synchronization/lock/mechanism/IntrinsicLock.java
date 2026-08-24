package com.core.java.multithreading.synchronization.lock.mechanism;

public class IntrinsicLock {

/*    An intrinsic lock is a Java mechanism associated with every object.
               LOCKING MECHANISM
                       │
        ┌──────────────┼──────────────┐
        │              │              │
    Intrinsic        Reentrant       ReadWrite
    Lock             Lock            Lock
        │
        │
        ▼
    Java mechanism
*/

    /*
     * Intrinsic Lock:
     * Every Java object has an intrinsic lock mechanism (also called monitor lock).
     * When a thread enters a synchronized block/method, it must acquire the intrinsic lock of the object.
     * Only ONE thread can hold the same intrinsic lock at a time.
     */

    public void printNumbers() {

        /*
         * "this" refers to the current IntrinsicLock object.
         * synchronized (this) means:
         *     Acquire the intrinsic lock of this object before entering the block.
         *     Release the lock when leaving the block.
         */
        synchronized (this) {

            System.out.println(Thread.currentThread().getName() + " acquired the intrinsic lock");

            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
                try {
                    /*
                     * IMPORTANT:
                     * sleep() pauses the thread, but it DOES NOT release the intrinsic lock.
                     * Therefore, the other thread must still wait for this thread to release the lock.
                     */
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            System.out.println(Thread.currentThread().getName() + " releasing the intrinsic lock");
        }

        /*
         * The synchronized block has finished.
         * The intrinsic lock is automatically released here.
         */
    }

    public static void main(String[] args) {

        /*
         * Create ONE shared object.
         * Both threads will use the same object, so both threads will compete for the SAME intrinsic lock.
         */
        IntrinsicLock obj = new IntrinsicLock();

        /*
         * Both threads call printNumbers() on the SAME object.
         * Inside printNumbers():
         *     synchronized (this)
         *
         * "this" refers to the same "obj" for both threads.
         */
        Thread t1 = new Thread(obj::printNumbers, "Thread-1");
        Thread t2 = new Thread(obj::printNumbers, "Thread-2");

        // Start both threads.
        t1.start();
        t2.start();
    }
}

// Key Points:
//
// Every Java object
//       ↓
// has an intrinsic lock (monitor)
//
// synchronized (object)
//       ↓
// acquires that object's intrinsic lock
//
// synchronized (this)
//       ↓
// acquires the current object's intrinsic lock
//
//
//
// In this example:
//
// obj
//  ↓
// has an intrinsic lock
//
// Thread-1 ---> tries to acquire object lock
// Thread-2 ---> tries to acquire object lock
//
//       ↓
//
// Only ONE thread can acquire the lock.
//
//       ↓
//
// Thread-1 ---> [ LOCK ] ---> executes synchronized block
// Thread-2 ---> [ WAITING ]
//
//       ↓
//
// Thread-1 exits synchronized block
//
//       ↓
//
// Lock is automatically released
//
//       ↓
//
// Thread-2 ---> acquires the lock
//
//
//
// IMPORTANT:
//
// synchronized (this)
//      ≈
// public synchronized void printNumbers()
//
// Both use the intrinsic lock of the current object.
//
//
//
// Also:
//
// Thread.sleep()
//      ↓
// Does NOT release the intrinsic lock.
//
// synchronized block exits
//      ↓
// Intrinsic lock is automatically released.
