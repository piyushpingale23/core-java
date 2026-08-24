package com.core.java.multithreading.thread_creation.lambda;

public class ThreadLambdaExample {

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {

            for (int i = 1; i <= 5; i++) {

                System.out.println(Thread.currentThread().getName() + " : " + i);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }

        });

        t1.start();

        System.out.println("Main thread continues...");
    }
}
