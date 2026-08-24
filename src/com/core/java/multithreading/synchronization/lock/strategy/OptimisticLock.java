package com.core.java.multithreading.synchronization.lock.strategy;

import java.util.concurrent.atomic.AtomicInteger;

public class OptimisticLock {

    /*
     * Optimistic Locking:
     * "Assume that a conflict probably will NOT happen."
     * Unlike synchronized/pessimistic locking, a thread does NOT acquire a lock before accessing the shared data.
     * Instead:
     *     1. Read the current value + version
     *     2. Do the work
     *     3. Before updating, check whether the version is unchanged
     *     4. If unchanged -> update successfully
     *     5. If changed   -> conflict detected
     * In Java, AtomicInteger / CAS (Compare-And-Set) is commonly used to implement this kind of optimistic approach.
     */

    private final AtomicInteger balance = new AtomicInteger(1000);

    public void withdraw(int amount) {

        int currentBalance = balance.get();

        System.out.println(Thread.currentThread().getName() + " read balance: " + currentBalance);

        if (currentBalance < amount) {
            System.out.println(Thread.currentThread().getName() + " -> Insufficient balance");
            return;
        }

        try {

            Thread.sleep(1000);

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();
            return;
        }

        /*
         * Calculate the new balance based on the value we read earlier.
         */
        int newBalance = currentBalance - amount;

        /*
         * compareAndSet() performs an atomic check + update.
         * It means:
         * "Update balance to newBalance ONLY IF the balance is still currentBalance."
         * If another thread changed the balance after we read it, compareAndSet() returns false.
         * No thread is blocked waiting for a lock.
         */
        boolean updated = balance.compareAndSet(currentBalance, newBalance);

        if (updated) {
            // CAS succeeded.
            // Nobody changed the balance after we read it.
            System.out.println(Thread.currentThread().getName() + " -> Withdrawal successful");

            System.out.println("Remaining balance: " + balance.get());
        } else {
            /*
             * CAS failed.
             * This means another thread changed the balance between our read and our update.
             * This is the CONFLICT.
             */
            System.out.println(Thread.currentThread().getName() + " -> Conflict detected!");
            System.out.println("Balance was changed by another thread.");

            /*
             * In a real optimistic-locking implementation,
             * we could retry the operation using the latest value.
             */
        }
    }

    public static void main(String[] args) {

        /*
         * Create ONE shared account.
         * Both threads access the same balance.
         */
        OptimisticLock account = new OptimisticLock();

        /*
         * Both threads try to withdraw 700.
         * Both may initially read:
         *     balance = 1000
         * But only one can successfully perform the CAS update.
         */
        Thread t1 = new Thread(() -> account.withdraw(700), "Thread-1");
        Thread t2 = new Thread(() -> account.withdraw(700), "Thread-2");

        // Start both threads.
        t1.start();
        t2.start();
    }
}
