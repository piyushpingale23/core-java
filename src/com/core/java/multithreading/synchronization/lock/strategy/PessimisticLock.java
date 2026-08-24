package com.core.java.multithreading.synchronization.lock.strategy;

public class PessimisticLock {

    /*
     * Pessimistic Lock:
     * "Assume a conflict will happen."
     * A thread acquires the lock BEFORE accessing the shared resource.
     * While one thread holds the lock: Other threads must WAIT.
     * In this example, synchronized is used to implement a pessimistic locking approach.
     */

    private int balance = 1000;

    public synchronized void withdraw(int amount) {
        /*
         * synchronized instance method:
         * The current object ("this") is locked.
         * Only ONE thread can execute this method on the same object at a time.
         * Other threads trying to withdraw from the same object must wait for the lock.
         */
        System.out.println(Thread.currentThread().getName() + " acquired lock");
        try {

            /*
             * Simulate some processing time.
             * IMPORTANT:
             * sleep() does NOT release the lock.
             * Therefore, other threads still have to wait.
             */
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }

        /*
         * Check the balance while holding the lock.
         * No other thread can modify the balance through this synchronized method at the same time.
         */
        if (balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew: " + amount);
            System.out.println("Remaining balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " insufficient balance");
        }

        /*
         * When this synchronized method finishes, the lock is automatically released.
         */
        System.out.println(Thread.currentThread().getName() + " released lock");
    }

    public static void main(String[] args) {

        /*
         * Create ONE shared account object.
         * Both threads will access the same balance.
         */
        PessimisticLock account = new PessimisticLock();

        /*
         * Both threads try to withdraw money from the SAME account.
         */
        Thread t1 = new Thread(() -> account.withdraw(700), "Thread-1");
        Thread t2 = new Thread(() -> account.withdraw(700), "Thread-2");

        /*
         * Start both threads.
         * One thread will acquire the lock first.
         * The other thread will WAIT until the first thread releases the lock.
         */
        t1.start();
        t2.start();
    }
}
