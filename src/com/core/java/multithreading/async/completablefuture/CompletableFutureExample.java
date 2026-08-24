package com.core.java.multithreading.async.completablefuture;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {

    public static void main(String[] args) {

        System.out.println("Main method start by thread : " + Thread.currentThread().getName());

        // Creates a CompletableFuture and executes the task asynchronously.
        //
        // supplyAsync() executes the task using a thread from
        // the default ForkJoinPool.commonPool().
        //
        // The task returns a String, so the CompletableFuture is CompletableFuture<String>.
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {

            // This code executes on a worker thread.
            // It normally does NOT execute on the main thread.
            System.out.println("Task running on: " + Thread.currentThread().getName());

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            // This value becomes the result of the CompletableFuture.
            return "Task Completed";
        });

        // This executes immediately on the main thread.
        //
        // Unlike Future.get(), we are NOT waiting here for the task to finish.
        System.out.println("Main thread continues...");

        // thenAccept() registers an action that should execute
        // when the CompletableFuture completes successfully.
        //
        // We don't need to call get() to retrieve the result.
        //
        // When the result becomes available, this code will execute.
        CompletableFuture<Void> resultFuture = completableFuture.thenAccept(result -> {

            // 'result' contains "Task Completed".
            System.out.println("Result = " + result + " produced by thread : " + Thread.currentThread().getName());
        });

        System.out.println("Before Join");

        resultFuture.join();

        System.out.println("After Join");

        System.out.println("Main method end by thread : " + Thread.currentThread().getName());

    }
}

/*
 * ================================================================
 * EXECUTION FLOW
 * ================================================================
 *
 * Step 1:
 * main() starts execution on the "main" thread.
 *
 * Step 2:
 * supplyAsync() is called.
 *
 * Since no Executor is provided, CompletableFuture uses the
 * default ForkJoinPool.commonPool() for asynchronous execution.
 *
 * Main thread submits the task to the ForkJoinPool worker thread.
 *
 *     main thread
 *          |
 *          | submit task
 *          v
 *     ForkJoinPool worker
 *
 * Step 3:
 * supplyAsync() returns a CompletableFuture immediately.
 *
 * IMPORTANT:
 * The main thread does NOT wait for the 5-second task.
 *
 * Main thread continues executing the next statements.
 *
 * At the same time, ForkJoinPool worker executes:
 *
 *     System.out.println("Task running...");
 *     Thread.sleep(5000);
 *
 * So two threads can execute concurrently:
 *
 *     main thread                    ForkJoinPool worker
 *         |                                  |
 *         |---- continues -----------------> |
 *         |                                  | sleep(5 sec)
 *
 * Step 4:
 * Main thread executes:
 *
 *     System.out.println("Main thread continues...");
 *
 * This can execute while the asynchronous task is still running.
 *
 * Step 5:
 * thenAccept() is called.
 *
 * It does NOT wait for the result.
 *
 * It registers a callback/action:
 *
 *     "When future completes, execute this code."
 *
 *     future
 *       |
 *       | completed
 *       v
 *     thenAccept(result -> ...)
 *
 * Step 6:
 * Main thread prints:
 *
 *     Before Join
 *
 * Step 7:
 * Main thread reaches:
 *
 *     resultFuture.join();
 *
 * IMPORTANT:
 * join() is a blocking operation.
 *
 * Main thread now WAITS until resultFuture is completed.
 *
 *     Main thread
 *          |
 *          v
 *       join()
 *          |
 *        BLOCK
 *          |
 *          |       ForkJoinPool worker
 *          |              |
 *          |              v
 *          |         task executes
 *          |              |
 *          |         sleep(5 sec)
 *          |              |
 *          |              v
 *          |       return "Task Completed"
 *          |              |
 *          |              v
 *          |         thenAccept()
 *          |              |
 *          +--------------+
 *
 * Step 8:
 * Once the asynchronous task completes, thenAccept() processes
 * the result.
 *
 *     Result = Task Completed
 *
 * thenAccept() normally executes on the thread that completes
 * the previous stage, which in this example is the ForkJoinPool
 * worker thread.
 *
 * Step 9:
 * resultFuture is now completed.
 *
 * Therefore join() returns and the main thread continues.
 *
 * Step 10:
 * Main thread executes:
 *
 *     System.out.println("After Join");
 *
 * Step 11:
 * main() finishes on the main thread.
 *
 *
 * ================================================================
 * IMPORTANT MEMORY POINTS
 * ================================================================
 *
 * 1. supplyAsync()
 *    -> submits task asynchronously
 *    -> does NOT make main thread wait
 *
 * 2. No Executor provided
 *    -> CompletableFuture uses ForkJoinPool.commonPool()
 *
 * 3. thenAccept()
 *    -> registers an action for the completed result
 *    -> does NOT block the main thread
 *
 * 4. join()
 *    -> WAITS for the CompletableFuture to complete
 *    -> blocks the calling thread
 *
 * 5. CompletableFuture itself is asynchronous.
 *    Calling join() can make the caller wait/block.
 *
 * 6. "After Join" is delayed because of join(),
 *    NOT because CompletableFuture is synchronous.
 *
 * ================================================================
 */