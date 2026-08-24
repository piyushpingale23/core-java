package com.core.java.multithreading.thread_interrupt;

public class InterruptExample extends Thread {

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {

            try {
                System.out.println("Child thread execution: " + i);

                // Child thread goes to TIMED_WAITING state.
                Thread.sleep(2000);

            } catch (InterruptedException e) {

                System.out.println("Child thread was interrupted!");

                // Restore the interrupted status.
                Thread.currentThread().interrupt();

                return;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Main thread start!");

        InterruptExample t1 = new InterruptExample();

        t1.start();

        // Let the child thread run for 3 seconds.
        Thread.sleep(3000);

        // Send an interrupt request to the child thread.
        t1.interrupt();

        System.out.println("Main thread end!");
    }
}
