package com.core.java.multithreading.thread_creation.thread_class;

/**
 * Important Concept: Overload the run() method <br>
 * <br>
 * 1. Thread class already defines a method: <br>
 *    public void run() <br>
 * <br>
 * 2. When we override run() without arguments: <br>
 *    we are defining the task that will run in a new thread. <br>
 * <br>
 * 3. When we call t2.start(): <br>
 *    - JVM creates a new thread <br>
 *    - Internally JVM calls the overridden run() method (no-arg version) <br>
 * <br>
 * 4. If we define an overloaded run(int i): <br>
 *    - It is NOT part of thread execution lifecycle <br>
 *    - JVM never calls it automatically <br>
 *    - It behaves like a normal method <br>
 * <br>
 * 5. If we call run(int i) explicitly: <br>
 *    - It executes like a normal method call <br>
 *    - No new thread is created <br>
 *    - Execution happens in the main thread <br>
 */

public class MyThread2 extends Thread {

    // This method is part of thread execution lifecycle
    @Override
    public void run() {
        System.out.println("no-arg run method (executed by child thread)");
    }

    // This is NOT part of thread lifecycle (just method overloading)
    public void run(int i) {
        System.out.println("int-arg run method (normal method call)");
    }

    public static void main(String[] args) {

        MyThread2 t2 = new MyThread2();

        // Creates a new thread and calls run()
        t2.start();

        // Normal method call (NO new thread created)
        t2.run(10);

        System.out.println("Main Thread!");
    }
}