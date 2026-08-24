package com.core.java.multithreading.thread_prevention;

public class SleepExample extends Thread {

    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {

            System.out.println("Child thread execution: " + i);

            try {
                // Pauses the current thread for 1 second.
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("Main thread start!");

        SleepExample t1 = new SleepExample();
        t1.start();

        System.out.println("Main thread continues...");

        System.out.println("Main thread end!");
    }
}