package com.core.java.multithreading.async.completablefuture;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureMethods {

    public static void main(String[] args) {

        supplyAsyncExample();

        runAsyncExample();

        thenApplyExample();

        thenAcceptExample();

        chainingExample();

        thenComposeExample();
    }


    // ============================================================
    // 1. supplyAsync()
    // ============================================================

    private static void supplyAsyncExample() {

        // supplyAsync() executes the task asynchronously.
        //
        // The task returns a value ("Hello").
        //
        // Because we did not provide an Executor explicitly,
        // CompletableFuture uses ForkJoinPool.commonPool()
        // by default.
        //
        // Therefore, the task normally executes on a
        // ForkJoinPool worker thread.
        CompletableFuture<String> future =
                CompletableFuture.supplyAsync(() -> {
                    System.out.println("supplyAsync() Task Thread: " + Thread.currentThread().getName());

                    // This value becomes the result
                    // of the CompletableFuture.
                    return "Hello";
                });


        // This line executes on the main thread.
        //
        // supplyAsync() does not make the main thread wait
        // for the task to finish.
        System.out.println("Main Thread: " + Thread.currentThread().getName());


        // join() retrieves the result.
        //
        // If the task has not completed yet,
        // join() waits for the result.
        //
        // This is only being used here to demonstrate
        // the final result.
        String result = future.join();

        System.out.println("Result = " + result);
    }


    // ============================================================
    // 2. runAsync()
    // ============================================================

    private static void runAsyncExample() {

        // runAsync() executes a task asynchronously.
        //
        // Unlike supplyAsync(), the task does NOT return
        // a business result.
        //
        // Therefore, the type is:
        //
        // CompletableFuture<Void>
        CompletableFuture<Void> future =
                CompletableFuture.runAsync(() -> {
                    System.out.println("runAsync() Task Thread: " + Thread.currentThread().getName());
                    System.out.println("Performing some work...");
                });


        // This executes on the main thread.
        System.out.println("Main Thread continues...");


        // Waits for the asynchronous task to complete.
        //
        // There is no result because runAsync() returns Void.
        future.join();

        System.out.println("runAsync() completed");
    }


    // ============================================================
    // 3. thenApply()
    // ============================================================

    private static void thenApplyExample() {

        // First asynchronous operation.
        //
        // Result = "hello"
        CompletableFuture<String> future =
                CompletableFuture.supplyAsync(() -> {
                    System.out.println("supplyAsync Thread: " + Thread.currentThread().getName());
                    return "hello";
                });


        // thenApply() executes after the previous stage
        // successfully completes.
        //
        // It receives the result of the previous stage.
        //
        // Here:
        //
        // "hello"
        //     ↓
        // toUpperCase()
        //     ↓
        // "HELLO"
        //
        // thenApply() returns another CompletableFuture.
        CompletableFuture<String> upperCaseFuture =
                future.thenApply(result -> {
                    System.out.println("thenApply Thread: " + Thread.currentThread().getName());
                    return result.toUpperCase();
                });


        // Retrieves the final result.
        String result = upperCaseFuture.join();

        System.out.println("Result = " + result);
    }


    // ============================================================
    // 4. thenAccept()
    // ============================================================

    private static void thenAcceptExample() {

        // First asynchronous operation.
        //
        // This task returns "Hello".
        CompletableFuture<String> future =
                CompletableFuture.supplyAsync(() -> "Hello");


        // thenAccept() receives the result of the previous stage.
        //
        // Unlike thenApply(), it does NOT produce another
        // business result.
        //
        // Therefore, the returned CompletableFuture is:
        //
        // CompletableFuture<Void>
        CompletableFuture<Void> resultFuture =
                future.thenAccept(result -> System.out.println("Result received: " + result));


        // Waits until the thenAccept() operation completes.
        resultFuture.join();

        System.out.println("thenAccept() completed");
    }


    // ============================================================
    // 5. Chaining operations
    // ============================================================

    private static void chainingExample() {

        // CompletableFuture operations can be chained together.
        //
        // Flow:
        //
        // supplyAsync()
        //       ↓
        //     "hello"
        //       ↓
        // thenApply()
        //       ↓
        //     "HELLO"
        //       ↓
        // thenApply()
        //       ↓
        //  "HELLO WORLD"
        //       ↓
        // thenAccept()
        //       ↓
        //     print
        // Second stage
        //
        // Transform "hello" into "HELLO".
        CompletableFuture<Void> future =
                CompletableFuture
                        .supplyAsync(() -> {

                            // First stage
                            return "hello";

                        })
                        .thenApply(String::toUpperCase)
                        .thenApply(result -> {

                            // Third stage
                            //
                            // Transform "HELLO" into
                            // "HELLO WORLD".
                            return result + " WORLD";

                        })
                        .thenAccept(result -> {

                            // Final stage.
                            //
                            // Consume the final result.
                            System.out.println(
                                    "Final Result = " + result
                            );

                        });


        // Waits for the complete chain to finish.
        future.join();
    }


    // ============================================================
    // 6. thenCompose()
    // ============================================================

    private static void thenComposeExample() {

        // First asynchronous operation.
        //
        // Imagine this represents:
        //
        // "Get User"
        CompletableFuture<String> userFuture =
                CompletableFuture.supplyAsync(() -> {
                    System.out.println("Getting user...");
                    return "Piyush";
                });


        // thenCompose() is used when the next operation
        // is itself asynchronous and depends on the
        // result of the previous operation.
        //
        // Flow:
        //
        // Get User
        //     ↓
        // "Piyush"
        //     ↓
        // Get User Details
        //     ↓
        // Final Result
        //
        // The user value is passed to the second
        // asynchronous operation.
        CompletableFuture<String> userDetailsFuture =
                userFuture.thenCompose(user -> {

                    // This is another asynchronous operation.
                    //
                    // Imagine this is an API call such as:
                    //
                    // GET /users/Piyush/details
                    return CompletableFuture.supplyAsync(() -> {
                        System.out.println("Getting details for: " + user);
                        return "Details of " + user;
                    });
                });


        // Retrieves the final result.
        String result = userDetailsFuture.join();

        System.out.println("Final Result = " + result);
    }
}
