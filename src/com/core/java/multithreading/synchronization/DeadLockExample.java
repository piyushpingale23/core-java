package com.core.java.multithreading.synchronization;

public class DeadLockExample {

    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void method1() {

        synchronized (lock1) {
            System.out.println(Thread.currentThread().getName() + " acquired lock1");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            // Waiting for lock2
            synchronized (lock2) {
                System.out.println(Thread.currentThread().getName() + " acquired lock2");
            }
        }
    }

    public void method2() {

        synchronized (lock2) {
            System.out.println(Thread.currentThread().getName() + " acquired lock2");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            // Waiting for lock1
            synchronized (lock1) {
                System.out.println(Thread.currentThread().getName() + " acquired lock1");
            }
        }
    }

    public static void main(String[] args) {

        DeadLockExample obj = new DeadLockExample();

        Thread t1 = new Thread(obj::method1, "Thread-1");
        Thread t2 = new Thread(obj::method2, "Thread-2");

        t1.start();
        t2.start();
    }
}
