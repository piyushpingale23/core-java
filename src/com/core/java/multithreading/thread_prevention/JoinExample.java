package com.core.java.multithreading.thread_prevention;

public class JoinExample extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }

            System.out.println("Child thread execution: " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Main thread start!");

        JoinExample t1 = new JoinExample();
        t1.start();

        // Main thread waits until child thread (t1) completes.
        t1.join();

        // This executes only after t1 has finished.
        System.out.println("Main thread end!");
    }
}