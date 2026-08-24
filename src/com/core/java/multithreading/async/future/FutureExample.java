package com.core.java.multithreading.async.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        System.out.println("Main method start by thread : " + Thread.currentThread().getName());

        // Creates an ExecutorService with a fixed thread pool of 2 worker threads.
        // Maximum 2 tasks can execute concurrently.
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Submits the task to the ExecutorService.
        //
        // The task does NOT execute on the main thread.
        // One available worker thread from the pool executes this task.
        //
        // submit() immediately returns a Future object.
        // Future represents the result that will be available later.
        Future<String> future = executor.submit(() -> {

            // This code executes on an ExecutorService worker thread.
            // It is NOT executed by the main thread.
            System.out.println("Task running on: " + Thread.currentThread().getName());

            // Worker thread sleeps for 5 seconds.
            // During this time, the task is still running.
            Thread.sleep(5000);

            // After 5 seconds, the worker thread produces the result.
            // This result will be stored in the Future object.
            return "Task Completed";

        });

        // This line executes on the main thread immediately after submit().
        // The main thread does NOT wait for the worker task to complete here.
        System.out.println("Main thread continues...");

        // get() asks the Future for the result.
        //
        // If the worker thread has not finished yet:
        //     -> the main thread BLOCKS/WAITS here.
        //
        // If the worker thread has already finished:
        //     -> get() immediately returns the result.
        //
        // After approximately 5 seconds, it returns "Task Completed".
        String result = future.get();

        // This executes on the main thread after future.get() returns.
        // At this point, the worker task has completed and the result is available.
        System.out.println("Result = " + result + " produced by thread : " + Thread.currentThread().getName());

        // Gracefully shuts down the ExecutorService.
        // No new tasks will be accepted.
        // Already submitted tasks are allowed to complete.
        executor.shutdown();

        System.out.println("Main method end by thread : " + Thread.currentThread().getName());
    }
}

/*
 * =====================================================================
 * FUTURE - EXECUTION FLOW
 * =====================================================================
 *
 * Step 1:
 * main() starts execution on the "main" thread.
 *
 *     Main Thread
 *          |
 *          v
 *       main()
 *
 *
 * Step 2:
 * ExecutorService is created:
 *
 *     Executors.newFixedThreadPool(2)
 *
 * This creates a thread pool with 2 worker threads.
 *
 *     ExecutorService
 *          |
 *          +---- Worker-1
 *          |
 *          +---- Worker-2
 *
 * These worker threads are available to execute submitted tasks.
 *
 *
 * Step 3:
 * main thread calls:
 *
 *     executor.submit(task)
 *
 * The task is submitted to the ExecutorService.
 *
 * submit() does NOT execute the task on the main thread.
 *
 * Instead:
 *
 *     Main Thread
 *          |
 *          | submit(task)
 *          v
 *     ExecutorService
 *          |
 *          v
 *     Available Worker Thread
 *
 *
 * Step 4:
 * submit() immediately returns a Future object.
 *
 *     Future<String> future
 *
 * Future represents:
 *
 *     "The result of the task that will be available later."
 *
 * At this point, the result is NOT necessarily available yet.
 *
 *
 * Step 5:
 * The worker thread starts executing the task:
 *
 *     System.out.println("Task running...");
 *     Thread.sleep(5000);
 *
 * IMPORTANT:
 *
 * The worker thread is busy executing the task.
 *
 *     Worker Thread
 *          |
 *          v
 *     Task running
 *          |
 *          v
 *     sleep(5 seconds)
 *
 *
 * Step 6:
 * While the worker thread is executing the task,
 * the main thread continues execution.
 *
 * It executes:
 *
 *     System.out.println("Main thread continues...");
 *
 * IMPORTANT:
 *
 * submit() did NOT block the main thread.
 *
 *
 * Step 7:
 * Main thread reaches:
 *
 *     future.get();
 *
 * This is the IMPORTANT point in Future.
 *
 * get() asks:
 *
 *     "Give me the result of this task."
 *
 * If the task is NOT completed:
 *
 *     Main Thread
 *          |
 *          v
 *       future.get()
 *          |
 *        BLOCK / WAIT
 *          |
 *          |       Worker Thread
 *          |            |
 *          |            v
 *          |        sleep(5 sec)
 *          |            |
 *          |            v
 *          |      return "Task Completed"
 *          |            |
 *          +------------+
 *
 *
 * Step 8:
 * Worker thread completes the task:
 *
 *     return "Task Completed";
 *
 * The result is now available through the Future.
 *
 *
 * Step 9:
 * future.get() now returns the result.
 *
 *     String result = future.get();
 *
 * Main thread is no longer blocked.
 *
 * result = "Task Completed"
 *
 *
 * Step 10:
 * Main thread prints:
 *
 *     Result = Task Completed
 *
 * IMPORTANT:
 *
 * future.get() is executed by the MAIN thread.
 *
 * The task itself was executed by the WORKER thread.
 *
 *
 * Step 11:
 * Main thread calls:
 *
 *     executor.shutdown();
 *
 * This tells ExecutorService:
 *
 *     "Do not accept any new tasks."
 *
 * Already submitted tasks are allowed to finish.
 *
 *
 * Step 12:
 * Main thread prints:
 *
 *     Main method end
 *
 * The program finishes.
 *
 *
 * =====================================================================
 * COMPLETE FLOW
 * =====================================================================
 *
 *                  ExecutorService
 *                        |
 *                        v
 * Main Thread ------ submit(task)
 *      |                 |
 *      |                 v
 *      |             Worker Thread
 *      |                 |
 *      |                 v
 *      |             execute task
 *      |                 |
 *      |                 v
 *      |             sleep(5 sec)
 *      |                 |
 *      |                 v
 *      |          "Task Completed"
 *      |                 |
 *      |                 v
 *      |              Future
 *      |                 |
 *      v                 |
 * Main continues         |
 *      |                 |
 *      v                 |
 *   future.get() <-------+
 *      |
 *      | result available
 *      v
 * Main continues
 *      |
 *      v
 * executor.shutdown()
 *      |
 *      v
 * Main ends
 *
 *
 * =====================================================================
 * IMPORTANT MEMORY POINTS
 * =====================================================================
 *
 * 1. ExecutorService
 *    -> manages a pool of worker threads.
 *
 * 2. submit()
 *    -> submits a task to the thread pool.
 *    -> returns immediately with a Future.
 *    -> does NOT block the calling thread.
 *
 * 3. Future
 *    -> represents the result of an asynchronous task.
 *    -> result may not be available immediately.
 *
 * 4. future.get()
 *    -> retrieves the result.
 *    -> BLOCKS the calling thread if the task is not completed.
 *
 * 5. The task runs on:
 *    -> ExecutorService worker thread.
 *
 * 6. future.get() runs on:
 *    -> The thread that calls get().
 *    -> In this example, the main thread.
 *
 * 7. executor.shutdown()
 *    -> stops accepting new tasks.
 *    -> allows already submitted tasks to complete.
 *
 *
 * =====================================================================
 * FUTURE MENTAL MODEL
 * =====================================================================
 *
 *     submit()
 *        |
 *        v
 *   Future returned
 *        |
 *        +----------------------+
 *        |                      |
 *        v                      v
 * Main thread              Worker thread
 * continues                executes task
 *        |                      |
 *        v                      v
 *    future.get()          task completes
 *        |                      |
 *        | BLOCK if needed      |
 *        +----------------------+
 *                   |
 *                   v
 *             Result available
 *                   |
 *                   v
 *             Main continues
 *
 *
 * =====================================================================
 * ONE-LINE MEMORY FORMULA
 * =====================================================================
 *
 * submit() -> Future -> Main continues -> get() -> WAIT if needed
 *           -> Worker completes -> Result -> Main continues
 *
 *
 * =====================================================================
 */