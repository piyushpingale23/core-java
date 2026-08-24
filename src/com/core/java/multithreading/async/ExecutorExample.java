package com.core.java.multithreading.async;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/*
 * Executor:
 *
 * - Executor is the simplest abstraction for executing tasks.
 * - It accepts a Runnable task.
 * - Method: void execute(Runnable command)
 * - It does NOT return a result.
 * - It does NOT return a Future.
 * - The Executor interface itself does not provide a way
 *   to check whether a submitted task is completed.
 *
 * In this example:
 *
 *     Executor
 *         ↓
 *     execute(Runnable)
 *         ↓
 *     Thread Pool executes the task
 */
public class ExecutorExample {

    public static void main(String[] args) {

        // This code runs on the main thread.
        System.out.println("Main start by thread : " + Thread.currentThread().getName());

        /*
         * Executors.newFixedThreadPool(10)
         * Creates an ExecutorService with a pool of 10 worker threads.
         * However, we store it in an Executor reference.
         * Therefore, we can only use the methods available in the Executor interface, such as execute().
         */
        Executor executor = Executors.newFixedThreadPool(10);

        /*
         * execute() accepts a Runnable.
         * Runnable:
         *     - performs some work
         *     - returns nothing (void)
         * The task is submitted to the Executor.
         * IMPORTANT:
         * execute() does NOT execute the task on the main thread.
         * A worker thread from the thread pool executes it.
         */
        executor.execute(() -> {

            // This code runs on a worker thread from the thread pool.
            System.out.println("Executor start by thread : " + Thread.currentThread().getName());

            try {

                // Simulate some work.
                // IMPORTANT: sleep() pauses the worker thread for 2 seconds.
                Thread.sleep(2000);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }

            // This also runs on the worker thread.
            System.out.println("Executor end by thread : " + Thread.currentThread().getName());
        });

        /*
         * Main thread does NOT wait for execute() to finish.
         * execute() submits the task and returns immediately.
         * Therefore, this line can execute while the worker thread is still sleeping.
         */
        System.out.println("Main end by thread : " + Thread.currentThread().getName());
    }
}