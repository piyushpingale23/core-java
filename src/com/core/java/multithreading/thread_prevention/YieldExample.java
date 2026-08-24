package com.core.java.multithreading.thread_prevention;

public class YieldExample extends Thread {

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {

            System.out.println(Thread.currentThread().getName() + " execution: " + i);

            // Hint to the scheduler that the current thread
            // is willing to give another thread a chance to execute.
            Thread.yield();
        }
    }

    public static void main(String[] args) {

        System.out.println("Main thread start!");

        YieldExample t1 = new YieldExample();
        YieldExample t2 = new YieldExample();

        t1.setName("Child-1");
        t2.setName("Child-2");

        t1.start();
        t2.start();

        System.out.println("Main thread end!");
    }
}