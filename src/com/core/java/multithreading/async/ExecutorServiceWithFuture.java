package com.core.java.multithreading.async;

import java.util.concurrent.*;

/*
 * ExecutorService + Future
 *
 * ExecutorService:
 * - Extends Executor
 * - Can execute/submit tasks
 * - Manages a thread pool
 * - submit() returns a Future
 *
 * Future:
 * - Represents the result/status of an asynchronous task
 * - Can wait for the task to complete
 * - Can check whether the task is completed
 * - Can cancel the task
 * - Can retrieve the task result
 *
 * Important:
 *
 *     submit()
 *         ↓
 *     Task runs asynchronously
 *         ↓
 *     Future returned immediately
 *
 *     future.get()
 *         ↓
 *     Main thread waits/block until task completes
 */
public class ExecutorServiceWithFuture {

    public static void main(String[] args)
            throws ExecutionException, InterruptedException {

        // This code runs on the main thread.
        System.out.println("Main start by thread : " + Thread.currentThread().getName());

        /*
         * Create a fixed thread pool containing 10 worker threads.
         * ExecutorService provides more functionality than Executor, including submit(), shutdown(), etc.
         */
        ExecutorService executorService =
                Executors.newFixedThreadPool(10);

        /*
         * submit() accepts the task and returns a Future.
         * The task does NOT execute on the main thread.
         * A worker thread from the pool executes the task.
         * Future<?> means:
         * - We have a Future representing this task.
         * - The task is a Runnable, so it does not produce a result.
         * - Therefore, future.get() will return null after completion.
         */
        Future<?> future = executorService.submit(() -> {

            // This code runs on a worker thread.
            System.out.println("ExecutorService start by thread : " + Thread.currentThread().getName());

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }

            // Worker thread completes the task.
            System.out.println("ExecutorService end by thread : " + Thread.currentThread().getName());
        });

        /*
         * get() is the important part.
         * future.get() BLOCKS the current thread (main) until the submitted task completes.
         * Since the task takes approximately 2 seconds, the main thread waits approximately 2 seconds here.
         * After the task completes:
         *     future.get() returns
         *          ↓
         *     Main thread continues
         * Because Runnable returns no value, future.get() returns null.
         */
        System.out.println(future.get());

        /*
         * This line executes ONLY AFTER future.get() returns.
         * Therefore, the worker task has already completed.
         */
        System.out.println("Main end by thread : " + Thread.currentThread().getName());

        /*
         * Shutdown the ExecutorService.
         * This tells the executor that no more tasks will be submitted.
         */
        executorService.shutdown();
    }
}